package ru.golden.currencyconverter.base.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.golden.currencyconverter.BuildConfig
import ru.golden.currencyconverter.base.debug

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 13:32
 */
interface RetrofitProvider {

	fun provide(): Retrofit
}

class RetrofitProviderImpl constructor(
	private val apiEndpoint: String
) : RetrofitProvider {

	private val retrofit: Retrofit by lazy {

		val httpClient = OkHttpClient.Builder()
			.apply {
				if (BuildConfig.DEBUG) {
					addNetworkInterceptor(getHttpLoggingInterceptor())
				}
			}
			.build()

		Retrofit.Builder()
			.baseUrl(apiEndpoint)
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.client(httpClient)
			.build()

	}

	override fun provide(): Retrofit = retrofit

	private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor(getLoggingInterceptorLogger())
		.apply { level = HttpLoggingInterceptor.Level.BODY }

	private fun getLoggingInterceptorLogger() = HttpLoggingInterceptor.Logger { debug(it) }
}