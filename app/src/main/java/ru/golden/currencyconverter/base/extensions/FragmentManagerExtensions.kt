package ru.golden.currencyconverter.base.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 14:35
 */
fun FragmentManager.start(
	fragmentArg: Fragment,
	container: Int = android.R.id.content,
	tag: String? = null,
	additionalAction: FragmentTransaction.() -> FragmentTransaction = { this }
) {
	beginTransaction()
		.additionalAction()
		.replace(container, fragmentArg, tag)
		.commit()
}