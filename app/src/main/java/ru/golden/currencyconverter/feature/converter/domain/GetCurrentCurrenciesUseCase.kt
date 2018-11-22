package ru.golden.currencyconverter.feature.converter.domain

import io.reactivex.Observable
import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.domain.converters.DtoConverter
import ru.golden.currencyconverter.feature.converter.presentation.SECOND_IN_MILLISECONDS
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 14:39
 */
interface GetCurrentCurrenciesUseCase {

	fun execute(base: String): Observable<List<CurrencyModel>>
}

class GetCurrentCurrenciesUseCaseImpl @Inject constructor(
	private val converterRepository: ConverterRepository,
	private val dtoConverter: DtoConverter
) : GetCurrentCurrenciesUseCase {

	override fun execute(base: String): Observable<List<CurrencyModel>> =
		Observable.interval(SECOND_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
			.flatMap {
				converterRepository.getFreshCurrencies(base).toObservable()
			}
			.map(dtoConverter::convert)

}