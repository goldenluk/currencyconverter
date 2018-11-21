package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.golden.currencyconverter.databinding.ItemConverterBinding
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 21:35
 */
class ConverterAdapter @Inject constructor() : RecyclerView.Adapter<ConverterAdapter.ConverterItemViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterItemViewHolder {

	}

	override fun getItemCount(): Int {

	}

	override fun onBindViewHolder(holder: ConverterItemViewHolder, position: Int) {

	}

	inner class ConverterItemViewHolder(
		private val binding: ItemConverterBinding
	) : RecyclerView.ViewHolder(binding.root) {


	}
}