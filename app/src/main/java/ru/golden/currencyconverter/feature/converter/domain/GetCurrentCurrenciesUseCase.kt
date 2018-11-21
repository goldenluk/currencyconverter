package ru.golden.currencyconverter.feature.converter.domain

import io.reactivex.Single
import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.domain.converters.DtoConverter
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 14:39
 */
interface GetCurrentCurrenciesUseCase {

	fun execute(base: String): Single<List<CurrencyModel>>
}

class GetCurrentCurrenciesUseCaseImpl @Inject constructor(
	private val converterRepository: ConverterRepository,
	private val dtoConverter: DtoConverter
) : GetCurrentCurrenciesUseCase {

	override fun execute(base: String): Single<List<CurrencyModel>> =
		converterRepository.getFreshCurrencies(base)
			.map(dtoConverter::convert)
}