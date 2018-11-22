package ru.golden.currencyconverter.baseui

import android.os.Bundle

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 10:40
 */
const val EXTRA_TITLE = "EXTRA_TITLE"
const val EXTRA_MESSAGE = "EXTRA_MESSAGE"

var Bundle.dialogTitle: String
	get() = getString(EXTRA_TITLE) ?: error("EXTRA_TITLE must be non null")
	set(value) = putString(EXTRA_TITLE, value)

var Bundle.dialogMessage: String
	get() = getString(EXTRA_MESSAGE) ?: error("EXTRA_MESSAGE must be non null")
	set(value) = putString(EXTRA_MESSAGE, value)