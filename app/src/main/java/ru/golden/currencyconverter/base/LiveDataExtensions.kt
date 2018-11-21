package ru.golden.currencyconverter.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 0:36
 */
fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, action: (T?) -> Unit) {
	this.observe(lifecycleOwner, Observer { action(it) })
}

fun <T> LiveData<T>.observeRequireNonNull(lifecycleOwner: LifecycleOwner, action: (T) -> Unit) {
	this.observe(lifecycleOwner, Observer { action(it!!) })
}