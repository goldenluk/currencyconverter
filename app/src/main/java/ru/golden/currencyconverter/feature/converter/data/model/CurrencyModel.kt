package ru.golden.currencyconverter.feature.converter.data.model

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 13:55
 */
data class CurrencyModel(
	val code: String,
	val name: String,
	val rateToBase: Double
)