package ru.golden.currencyconverter.feature.converter.domain.converters

import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 0:18
 */
interface UiModelConverter {

	fun convert(currencyModel: CurrencyModel, baseValue: Double): ConverterItemUiModel
}

class UiModelConverterImpl @Inject constructor() : UiModelConverter {

	override fun convert(currencyModel: CurrencyModel, baseValue: Double): ConverterItemUiModel {
		val uiModel = ConverterItemUiModel(
			name = currencyModel.name,
			code = currencyModel.code
		)

		uiModel.value.set(baseValue * currencyModel.rateToBase)

		return uiModel
	}
}