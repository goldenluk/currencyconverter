package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.databinding.ObservableField

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 14:19
 */
class ConverterItemUiModel(
	val name: String,
	val code: String
) {

	val value = ObservableField<Double>()
}