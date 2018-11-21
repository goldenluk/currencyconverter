package ru.golden.currencyconverter.feature.converter.presentation

import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.golden.currencyconverter.base.BaseViewModel
import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.domain.GetCurrentCurrenciesUseCase
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:19
 */
class ConverterViewModel @Inject constructor(
	private val getCurrentCurrenciesUseCase: GetCurrentCurrenciesUseCase
) : BaseViewModel() {

	private val currencyModels: List<CurrencyModel> = emptyList()

	private var getCurrentCurrenciesDisposable: Disposable? = null

	override fun onBind(state: Bundle?) {
		getCurrentCurrenciesDisposable = getCurrentCurrenciesUseCase.execute("EUR")
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(this::onCurrentCurrenciesLoaded, this::onCurrentCurrenciesLoadingFailed)
	}

	private fun onCurrentCurrenciesLoaded(currencies: List<CurrencyModel>) {

	}

	private fun onCurrentCurrenciesLoadingFailed(throwable: Throwable) {

	}

	override fun onUnbind() {
		getCurrentCurrenciesDisposable?.dispose()
	}
}