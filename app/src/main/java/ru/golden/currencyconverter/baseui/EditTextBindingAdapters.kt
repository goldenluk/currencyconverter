package ru.golden.currencyconverter.baseui

import android.databinding.BindingAdapter
import android.widget.EditText

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 1:41
 */
@BindingAdapter("doubleText")
fun text(editText: EditText, text: Double) =
	editText.setText("%.2f".format(text))