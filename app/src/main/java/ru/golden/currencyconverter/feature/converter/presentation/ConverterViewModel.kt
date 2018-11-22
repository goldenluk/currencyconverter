package ru.golden.currencyconverter.feature.converter.presentation

import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ru.golden.currencyconverter.base.BaseViewModel
import ru.golden.currencyconverter.base.SingleLiveEvent
import ru.golden.currencyconverter.base.extensions.debug
import ru.golden.currencyconverter.base.extensions.warning
import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.domain.CreateUiModelsUseCase
import ru.golden.currencyconverter.feature.converter.domain.GetCurrentCurrenciesUseCase
import ru.golden.currencyconverter.feature.converter.domain.UpdateItemsOrderingUseCase
import ru.golden.currencyconverter.feature.converter.domain.UpdateItemsValueUseCase
import ru.golden.currencyconverter.feature.converter.domain.constants.EURO_CODE
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:19
 */
class ConverterViewModel @Inject constructor(
	private val getCurrentCurrenciesUseCase: GetCurrentCurrenciesUseCase,
	private val createUiModelsUseCase: CreateUiModelsUseCase,
	private val updateItemsValueUseCase: UpdateItemsValueUseCase,
	private val updateItemsOrderingUseCase: UpdateItemsOrderingUseCase
) : BaseViewModel() {

	val currenciesLoadedEvent = SingleLiveEvent<List<ConverterItemUiModel>>()
	val currenciesUpdatedEvent = SingleLiveEvent<Unit>()
	val currenciesOrderingUpdatedEvent = SingleLiveEvent<List<ConverterItemUiModel>>()
	val errorEvent = SingleLiveEvent<Unit>()

	private val currencyModels = ArrayList<CurrencyModel>()

	private var getCurrentCurrenciesDisposable: Disposable? = null

	var baseCurrency = EURO_CODE

	override fun onBind(state: Bundle?) {
		onStartUpdating()
	}

	private fun onCurrentCurrenciesLoaded(currencies: List<CurrencyModel>) {
		if (currencies.isNotEmpty()) {
			if (currencyModels.isEmpty()) {
				currencyModels.addAll(currencies)
				currenciesLoadedEvent.postValue(createUiModelsUseCase.execute(currencies, DEFAULT_SUM))
			} else {
				currencyModels.clear()
				currencyModels.addAll(currencies)
				currenciesUpdatedEvent.call()
			}
		}
	}

	private fun onCurrentCurrenciesLoadingFailed(throwable: Throwable) {
		warning(throwable.message ?: "Error while getting currencies from api")
		errorEvent.call()
		onStopUpdating()
	}

	fun updateItemsValue(uiModels: List<ConverterItemUiModel>) {
		updateItemsValueUseCase.execute(uiModels, currencyModels)
			.subscribeOn(Schedulers.computation())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeBy(
				onComplete = { debug("Items updated") },
				onError = { warning("Error when updating items: $it") }
			)
	}

	fun onRefresh() {
		getCurrentCurrenciesDisposable?.let {
			if (it.isDisposed) {
				onStartUpdating()
			}
		}
	}

	private fun onStopUpdating() =
		getCurrentCurrenciesDisposable?.dispose()

	private fun onStartUpdating() {
		getCurrentCurrenciesDisposable = getCurrentCurrenciesUseCase.execute(baseCurrency)
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(this::onCurrentCurrenciesLoaded, this::onCurrentCurrenciesLoadingFailed)
	}

	override fun onUnbind() {
		getCurrentCurrenciesDisposable?.dispose()
	}

	fun onItemSelected(selectedCode: String, uiModels: List<ConverterItemUiModel>) {
		onStopUpdating()
		baseCurrency = selectedCode
		val updatedUiModels = updateItemsOrderingUseCase.execute(selectedCode, uiModels)
		currenciesOrderingUpdatedEvent.postValue(updatedUiModels)
		onStartUpdating()
	}

	fun onBaseValueChanged(newValue: String, uiModels: List<ConverterItemUiModel>) {
		uiModels.first().value.set(newValue.replace(",", ".").toDouble())
	}
}