package ru.golden.currencyconverter.feature.converter.data

import io.reactivex.Single
import ru.golden.currencyconverter.feature.converter.data.network.api.CurrencyApi
import ru.golden.currencyconverter.feature.converter.data.network.dto.CurrencyResponseDto
import ru.golden.currencyconverter.feature.converter.domain.ConverterRepository
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:44
 */
class ConverterRepositoryImpl @Inject constructor(
	private val api: CurrencyApi
) : ConverterRepository {

	override fun getFreshCurrencies(base: String): Single<CurrencyResponseDto> =
		api.getLatestCurrenciesByBase(base)
}