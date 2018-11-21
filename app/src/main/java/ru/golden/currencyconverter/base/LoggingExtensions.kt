package ru.golden.currencyconverter.base

import android.util.Log
import ru.golden.currencyconverter.BuildConfig

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 13:34
 */
fun Any.debug(message: String) = log(
	{ Log.d(this::class.java.simpleName, message) })

fun Any.info(message: String) = log(
	{ Log.i(this::class.java.simpleName, message) })

fun Any.warning(message: String) = log(
	{ Log.w(this::class.java.simpleName, message) })

fun severe(message: String, throwable: Throwable) = log(
	{ throw IllegalStateException(message, throwable) },
	{})

private inline fun log(debugAction: () -> Unit, releaseAction: () -> Unit = {}) {
	if (BuildConfig.DEBUG) {
		debugAction()
	} else {
		releaseAction()
	}
}