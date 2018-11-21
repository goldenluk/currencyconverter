package ru.golden.currencyconverter.feature.converter.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.golden.currencyconverter.di.FragmentScope
import ru.golden.currencyconverter.feature.converter.data.ConverterRepositoryImpl
import ru.golden.currencyconverter.feature.converter.data.network.api.CurrencyApi
import ru.golden.currencyconverter.feature.converter.domain.ConverterRepository
import ru.golden.currencyconverter.feature.converter.domain.GetCurrentCurrenciesUseCase
import ru.golden.currencyconverter.feature.converter.domain.GetCurrentCurrenciesUseCaseImpl
import ru.golden.currencyconverter.feature.converter.domain.converters.DtoConverter
import ru.golden.currencyconverter.feature.converter.domain.converters.DtoConverterImpl

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 20:39
 */
@Module
abstract class ConverterModule {

	@Module
	companion object {

		@Provides
		@FragmentScope
		@JvmStatic
		fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi = retrofit.create(CurrencyApi::class.java)
	}

	@Binds
	@FragmentScope
	abstract fun bindConverterRepository(impl: ConverterRepositoryImpl): ConverterRepository

	@Binds
	@FragmentScope
	abstract fun bindGetCurrentCurrenciesUseCase(impl: GetCurrentCurrenciesUseCaseImpl): GetCurrentCurrenciesUseCase

	@Binds
	@FragmentScope
	abstract fun bindDtoConverter(impl: DtoConverterImpl): DtoConverter
}