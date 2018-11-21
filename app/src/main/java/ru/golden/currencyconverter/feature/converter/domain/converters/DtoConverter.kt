package ru.golden.currencyconverter.feature.converter.domain.converters

import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.data.network.dto.CurrencyResponseDto
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 20:01
 */
interface DtoConverter {

	fun convert(dto: CurrencyResponseDto): List<CurrencyModel>
}

class DtoConverterImpl @Inject constructor() : DtoConverter {

	override fun convert(dto: CurrencyResponseDto): List<CurrencyModel> {
		val currencyModels = ArrayList<CurrencyModel>()

		return currencyModels
	}
}

