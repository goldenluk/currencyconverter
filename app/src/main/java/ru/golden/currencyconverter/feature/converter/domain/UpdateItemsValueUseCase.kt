package ru.golden.currencyconverter.feature.converter.domain

import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.presentation.DEFAULT_SUM
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 0:40
 */
interface UpdateItemsValueUseCase {

	fun execute(uiModelItems: List<ConverterItemUiModel>, currencyModels: List<CurrencyModel>)
}

class UpdateItemsValueUseCaseImpl @Inject constructor() : UpdateItemsValueUseCase {

	override fun execute(uiModelItems: List<ConverterItemUiModel>, currencyModels: List<CurrencyModel>) {
		uiModelItems.forEach { uiModel ->
			if (uiModel.code != uiModelItems.first().code) {
				val newRate = currencyModels.find { it.code == uiModel.code }?.rateToBase ?: 1.0
				val baseValue = uiModelItems.first().value.get() ?: DEFAULT_SUM
				uiModel.value.set(baseValue * newRate)
			}
		}
	}
}