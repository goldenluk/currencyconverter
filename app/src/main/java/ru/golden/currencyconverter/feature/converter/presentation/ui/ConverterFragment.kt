package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.os.Bundle
import ru.golden.currencyconverter.R
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

	override fun initBinding(binding: FragmentConverterBinding) {
		binding.viewModel = viewModel
	}

	override fun initViewModel(state: Bundle?) = viewModel.onBind(state)

	override fun onDestroy() {
		super.onDestroy()
		viewModel.onUnbind()
	}
}