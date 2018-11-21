package ru.golden.currencyconverter.baseui

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:38
 */
abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {

	protected abstract val layoutId: Int

	protected lateinit var binding: DB

	protected abstract fun initBinding(binding: DB)

	protected abstract fun initViewModel(state: Bundle?)

	override fun onAttach(context: Context) {
		AndroidSupportInjection.inject(this)
		super.onAttach(context)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		initViewModel(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View {
		binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		initBinding(binding)
	}
}