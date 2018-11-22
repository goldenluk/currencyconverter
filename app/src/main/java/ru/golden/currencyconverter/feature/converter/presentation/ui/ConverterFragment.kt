package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_converter.*
import ru.golden.currencyconverter.R
import ru.golden.currencyconverter.base.extensions.observe
import ru.golden.currencyconverter.base.extensions.observeRequireNonNull
import ru.golden.currencyconverter.baseui.BaseFragment
import ru.golden.currencyconverter.baseui.ConverterDialogFragment
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
		binding.swipeRefresh.setOnRefreshListener {
			viewModel.onRefresh()
			swipeRefresh.isRefreshing = false
		}
	}

	override fun initViewModel(state: Bundle?) {
		viewModel.onBind(state)

		viewModel.currenciesLoadedEvent.observeRequireNonNull(this) {
			adapter.items = it
		}

		viewModel.currenciesUpdatedEvent.observe(this) {
			viewModel.updateItemsValue(adapter.items)
		}

		viewModel.errorEvent.observe(this) {
			ConverterDialogFragment.create(requireActivity(), R.string.errorTitle, R.string.errorDescription).show(fragmentManager, null)
		}

		viewModel.currenciesOrderingUpdatedEvent.observeRequireNonNull(this) {
			adapter.items = it
		}

		adapter.itemSelectedEvent.observeRequireNonNull(this) {
			viewModel.itemSelected(it, adapter.items)
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		viewModel.onUnbind()
	}
}