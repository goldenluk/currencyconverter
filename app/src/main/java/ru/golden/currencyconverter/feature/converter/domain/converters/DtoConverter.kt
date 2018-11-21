package ru.golden.currencyconverter.feature.converter.domain.converters

import ru.golden.currencyconverter.feature.converter.data.model.CurrencyModel
import ru.golden.currencyconverter.feature.converter.data.network.dto.CurrencyResponseDto
import ru.golden.currencyconverter.feature.converter.domain.constants.*
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

		currencyModels.add(CurrencyModel(AUSTRALIAN_CODE, AUSTRALIAN_NAME, dto.rates.australian ?: 0.0))
		currencyModels.add(CurrencyModel(BRAZILIAN_CODE, BRAZILIAN_NAME, dto.rates.brazilian ?: 0.0))
		currencyModels.add(CurrencyModel(CANADIAN_CODE, CANADIAN_NAME, dto.rates.canadian ?: 0.0))
		currencyModels.add(CurrencyModel(CHINESE_CODE, CHINESE_NAME, dto.rates.chinese ?: 0.0))
		currencyModels.add(CurrencyModel(CZECH_CODE, CZECH_NAME, dto.rates.czech ?: 0.0))
		currencyModels.add(CurrencyModel(DANISH_CODE, DANISH_NAME, dto.rates.danish ?: 0.0))
		currencyModels.add(CurrencyModel(STERLING_CODE, STERLING_NAME, dto.rates.sterling ?: 0.0))
		currencyModels.add(CurrencyModel(MEXICAN_CODE, MEXICAN_NAME, dto.rates.mexican ?: 0.0))
		currencyModels.add(CurrencyModel(NORWEGIAN_CODE, NORWEGIAN_NAME, dto.rates.norwegian ?: 0.0))
		currencyModels.add(CurrencyModel(RUSSIAN_CODE, RUSSIAN_NAME, dto.rates.russian ?: 0.0))
		currencyModels.add(CurrencyModel(TURKISH_CODE, TURKISH_NAME, dto.rates.turkish ?: 0.0))
		currencyModels.add(CurrencyModel(AMERICAN_CODE, AMERICAN_NAME, dto.rates.american ?: 0.0))

		return currencyModels
	}
}

