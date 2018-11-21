package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.os.Bundle
import ru.golden.currencyconverter.R
import ru.golden.currencyconverter.base.observe
import ru.golden.currencyconverter.base.observeRequireNonNull
import ru.golden.currencyconverter.baseui.BaseFragment
import ru.golden.currencyconverter.databinding.FragmentConverterBinding
import ru.golden.currencyconverter.feature.converter.presentation.ConverterViewModel
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:20
 */
class ConverterFragment : BaseFragment<FragmentConverterBinding>() {

	override val layoutId: Int = R.layout.fragment_converter

	@Inject
	lateinit var viewModel: ConverterViewModel

	@Inject
	lateinit var adapter: ConverterAdapter

	override fun initBinding(binding: FragmentConverterBinding) {
		binding.viewModel = viewModel
		binding.recyclerView.adapter = adapter
	}

	override fun initViewModel(state: Bundle?) {
		viewModel.onBind(state)

		viewModel.currenciesLoadedEvent.observeRequireNonNull(this) {
			adapter.items = it
		}

		viewModel.currenciesUpdatedEvent.observe(this) {
			viewModel.updateItemsValue(adapter.items)
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		viewModel.onUnbind()
	}
}