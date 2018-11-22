package ru.golden.currencyconverter.baseui

import android.databinding.BindingAdapter
import android.widget.EditText
import ru.golden.currencyconverter.R

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 1:41
 */
@BindingAdapter("textOfDouble")
fun textOfDouble(editText: EditText, text: Double) =
	editText.setText(editText.context.getString(R.string.currencyFormat).format(text))