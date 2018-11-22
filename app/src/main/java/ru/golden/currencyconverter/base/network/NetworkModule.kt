package ru.golden.currencyconverter.base.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.golden.currencyconverter.di.ApplicationScope

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 13:36
 */
const val API_END_POINT = "https://revolut.duckdns.org"

@Module
abstract class NetworkModule {

	@Module
	companion object {

		@Provides
		@ApplicationScope
		@JvmStatic
		fun provideRetrofit(
			@ApiEndpoint apiEndpoint: String
		): Retrofit = RetrofitProviderImpl(apiEndpoint).provide()

		@Provides
		@ApplicationScope
		@ApiEndpoint
		@JvmStatic
		fun provideApiEndpoint(): String = API_END_POINT
	}
}