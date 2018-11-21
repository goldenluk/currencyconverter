package ru.golden.currencyconverter.base

import android.os.Bundle

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 12:16
 */
abstract class BaseViewModel {

	open fun onBind(state: Bundle? = null) = Unit

	open fun onUnbind() = Unit
}