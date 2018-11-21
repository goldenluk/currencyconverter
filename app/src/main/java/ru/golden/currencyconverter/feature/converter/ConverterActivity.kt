package ru.golden.currencyconverter.feature.converter

import android.os.Bundle
import ru.golden.currencyconverter.base.start
import ru.golden.currencyconverter.baseui.BaseActivity
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterFragment

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:43
 */
class ConverterActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		showConverter()
	}

	private fun showConverter() = supportFragmentManager.start(fragmentArg = ConverterFragment())
}