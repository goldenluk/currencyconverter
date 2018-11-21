package ru.golden.currencyconverter.feature.converter.data.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.golden.currencyconverter.feature.converter.data.network.dto.CurrencyResponseDto

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 13:40
 */
interface CurrencyApi {

	@GET("/latest?")
	fun getLatestCurrenciesByBase(@Query("base") base: String): Single<CurrencyResponseDto>
}