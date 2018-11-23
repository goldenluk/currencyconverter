package ru.golden.currencyconverter.feature.converter.domain

import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel
import java.util.*
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 22.11.2018
 * Time: 21:10
 */
interface UpdateItemsOrderingUseCase {

	fun execute(selectedCode: String, uiModels: List<ConverterItemUiModel>): List<ConverterItemUiModel>
}

class UpdateItemsOrderingUseCaseImpl @Inject constructor() : UpdateItemsOrderingUseCase {

	override fun execute(selectedCode: String, uiModels: List<ConverterItemUiModel>): List<ConverterItemUiModel> {
		val baseItem = uiModels.first()
		val selectedItem = uiModels.find { it.code == selectedCode }
		val selectedItemIndex = uiModels.indexOf(selectedItem)
		(uiModels as ArrayList)[0] = requireNotNull(selectedItem)
		uiModels[selectedItemIndex] = baseItem
		return uiModels
	}
}