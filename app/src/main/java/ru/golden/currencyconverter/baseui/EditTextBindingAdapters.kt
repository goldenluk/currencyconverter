package ru.golden.currencyconverter.baseui

import android.databinding.BindingAdapter
import android.widget.EditText

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 1:41
 */
const val NUMBER_OF_DIGITS_AFTER_COMMA = 2

@BindingAdapter("textOfDouble")
fun textOfDouble(editText: EditText, text: Double) {
	var textInString = text.toString()
	val indexOfComma = textInString.indexOf(".")

	if (textInString.substring(indexOfComma).length > NUMBER_OF_DIGITS_AFTER_COMMA + 1) {
		textInString = textInString.substring(0, indexOfComma + NUMBER_OF_DIGITS_AFTER_COMMA + 1)
	}
	var lastSelectionPosition = editText.selectionStart

	if (lastSelectionPosition >= textInString.length) {
		lastSelectionPosition = textInString.length
	}
	editText.setText(textInString)
	editText.setSelection(lastSelectionPosition)
}