package ru.golden.currencyconverter.feature.converter.domain

import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel

/**
 * User: Matvei Khadzhiev
 * Date: 23.11.2018
 * Time: 11:18
 */
val FIRST_CURRENCY_MODEL = CurrencyModel(
	code = "RUB",
	name = "Rouble",
	rateToBase = 1.12
)

val SECOND_CURRENCY_MODEL = CurrencyModel(
	code = "USD",
	name = "Dollar",
	rateToBase = 1.01
)

val FIRST_UI_MODEL = ConverterItemUiModel(
	name = "name",
	code = "code"
)

val SECOND_UI_MODEL = ConverterItemUiModel(
	name = "second name",
	code = "second code"
)