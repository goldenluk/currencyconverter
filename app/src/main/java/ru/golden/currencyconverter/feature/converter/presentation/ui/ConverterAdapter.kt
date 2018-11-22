package ru.golden.currencyconverter.feature.converter.presentation.ui

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.golden.currencyconverter.base.SingleLiveEvent
import ru.golden.currencyconverter.databinding.ItemConverterBinding
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 21:35
 */
class ConverterAdapter @Inject constructor() : RecyclerView.Adapter<ConverterAdapter.ConverterItemViewHolder>() {

	val itemSelectedEvent = SingleLiveEvent<String>()
	val baseValueChangedEvent = SingleLiveEvent<String>()

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
			val isFirstItem = items.first().code == uiModel.code
			binding.uiModel = uiModel
			binding.isValueEditable = isFirstItem
			binding.onItemClickAction = onItemClick
			if (isFirstItem) {
				binding.value.addTextChangedListener(textChangedListener)
			} else {
				binding.value.removeTextChangedListener(textChangedListener)
			}
		}

		private val textChangedListener = object : TextWatcher {

			var oldText = ""

			override fun afterTextChanged(text: Editable) {}

			override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) {
				oldText = text.toString()
			}

			override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
				if (text.toString() != oldText) {
					baseValueChangedEvent.postValue(text.toString())
				}
			}
		}

		private val onItemClick: (code: String) -> Unit = {
			itemSelectedEvent.postValue(it)
		}
	}
}