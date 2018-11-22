package ru.golden.currencyconverter.base.extensions

import android.os.Bundle

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 10:39
 */
fun bundleOf(block: Bundle.() -> Unit) = Bundle().apply(block)