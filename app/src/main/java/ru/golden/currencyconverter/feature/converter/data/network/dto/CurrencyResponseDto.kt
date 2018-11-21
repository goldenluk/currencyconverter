package ru.golden.currencyconverter.feature.converter.data.network.dto

import com.google.gson.annotations.SerializedName

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:51
 */
data class CurrencyResponseDto(
	val base: String,
	val date: String,
	val rates: Rates
)

data class Rates(
	@SerializedName("AUD") val australian: Double?,
	@SerializedName("BRL") val brazilian: Double?,
	@SerializedName("CAD") val canadian: Double?,
	@SerializedName("CNY") val chinese: Double?,
	@SerializedName("CZK") val czech: Double?,
	@SerializedName("DKK") val danish: Double?,
	@SerializedName("GBP") val sterling: Double?,
	@SerializedName("MXN") val mexican: Double?,
	@SerializedName("NOK") val norwegian: Double?,
	@SerializedName("RUB") val russian: Double?,
	@SerializedName("TRY") val turkish: Double?,
	@SerializedName("USD") val american: Double?
)