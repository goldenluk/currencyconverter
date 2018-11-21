package ru.golden.currencyconverter.feature.converter.domain

import io.reactivex.Single
import ru.golden.currencyconverter.feature.converter.data.network.dto.CurrencyResponseDto

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:42
 */
interface ConverterRepository {

	fun getFreshCurrencies(base: String) : Single<CurrencyResponseDto>
}