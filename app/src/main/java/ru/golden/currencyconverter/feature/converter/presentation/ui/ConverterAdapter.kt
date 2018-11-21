package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.golden.currencyconverter.databinding.ItemConverterBinding
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 21:35
 */
class ConverterAdapter @Inject constructor() : RecyclerView.Adapter<ConverterAdapter.ConverterItemViewHolder>() {

	var items = emptyList<ConverterItemUiModel>()
		set(value) {
			field = ArrayList(value)
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterItemViewHolder {
		val binding = ItemConverterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ConverterItemViewHolder(binding)
	}

	override fun getItemCount(): Int = items.size

	override fun onBindViewHolder(holder: ConverterItemViewHolder, position: Int) {
		holder.bind(items[position])
	}

	inner class ConverterItemViewHolder(
		private val binding: ItemConverterBinding
	) : RecyclerView.ViewHolder(binding.root) {

		fun bind(uiModel: ConverterItemUiModel) {
			binding.uiModel = uiModel
			binding.isValueEditable = items.first().code == uiModel.code
		}
	}
}