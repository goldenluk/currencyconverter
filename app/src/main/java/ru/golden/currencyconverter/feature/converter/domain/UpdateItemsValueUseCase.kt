package ru.golden.currencyconverter.feature.converter.domain

import io.reactivex.Completable
import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.presentation.DEFAULT_SUM
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 0:40
 */
const val BASE_RATE = 1.0

interface UpdateItemsValueUseCase {

	fun execute(uiModelItems: List<ConverterItemUiModel>, currencyModels: List<CurrencyModel>) : Completable
}

/**
 * Updating all values except first(base) value
 */
class UpdateItemsValueUseCaseImpl @Inject constructor() : UpdateItemsValueUseCase {

	override fun execute(uiModelItems: List<ConverterItemUiModel>, currencyModels: List<CurrencyModel>) : Completable =
		Completable.fromCallable {
			uiModelItems.forEach { uiModel ->
				if (uiModel.code != uiModelItems.first().code) {
					val newRate = currencyModels.find { it.code == uiModel.code }?.rateToBase ?: BASE_RATE
					val baseValue = uiModelItems.first().value.get() ?: DEFAULT_SUM
					uiModel.value.set(baseValue * newRate)
				}
			}
		}
}