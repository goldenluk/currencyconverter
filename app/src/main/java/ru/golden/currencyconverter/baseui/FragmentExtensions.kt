package ru.golden.currencyconverter.baseui

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 10:45
 */
fun Fragment.requireArguments(): Bundle = requireNotNull(arguments)