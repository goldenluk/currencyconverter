package ru.golden.currencyconverter.feature.converter.domain

import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.domain.converters.UiModelConverter
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 0:16
 */
interface CreateUiModelsUseCase {

	fun execute(currencyModels: List<CurrencyModel>, baseValue: Double): List<ConverterItemUiModel>
}

class CreateUiModelsUseCaseImpl @Inject constructor(
	private val uiModelConverter: UiModelConverter
) : CreateUiModelsUseCase {

	override fun execute(currencyModels: List<CurrencyModel>, baseValue: Double): List<ConverterItemUiModel> {
		val uiModels = ArrayList<ConverterItemUiModel>()

		uiModels.add(ConverterItemUiModel(
			name = "Euro",
			code = "EUR"
		))
		uiModels.first().value.set(baseValue)

		currencyModels.forEach {
			uiModels.add(uiModelConverter.convert(it, baseValue))
		}

		return uiModels
	}
}