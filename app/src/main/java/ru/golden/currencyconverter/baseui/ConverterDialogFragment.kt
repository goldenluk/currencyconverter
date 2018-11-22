package ru.golden.currencyconverter.baseui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import ru.golden.currencyconverter.base.extensions.bundleOf

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 10:35
 */
class ConverterDialogFragment : DialogFragment() {

	companion object {

		fun create(
			context: Context,
			titleResId: Int,
			descriptionResId: Int
		): ConverterDialogFragment = ConverterDialogFragment().apply {
			arguments = bundleOf {
				dialogTitle = context.getString(titleResId)
				dialogMessage = context.getString(descriptionResId)
			}
		}
	}

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
		AlertDialog.Builder(requireActivity())
			.setTitle(requireArguments().dialogTitle)
			.apply {
				setMessage(requireArguments().dialogMessage)
			}
			.setPositiveButton(android.R.string.ok, null)
			.create()

}