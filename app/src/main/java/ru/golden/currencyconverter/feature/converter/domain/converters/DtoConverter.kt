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

		dto.rates.australian?.let { currencyModels.add(CurrencyModel(AUSTRALIAN_CODE, AUSTRALIAN_NAME, it)) }
		dto.rates.brazilian?.let { currencyModels.add(CurrencyModel(BRAZILIAN_CODE, BRAZILIAN_NAME, it)) }
		dto.rates.canadian?.let { currencyModels.add(CurrencyModel(CANADIAN_CODE, CANADIAN_NAME, it)) }
		dto.rates.chinese?.let { currencyModels.add(CurrencyModel(CHINESE_CODE, CHINESE_NAME, it)) }
		dto.rates.czech?.let { currencyModels.add(CurrencyModel(CZECH_CODE, CZECH_NAME, it)) }
		dto.rates.danish?.let { currencyModels.add(CurrencyModel(DANISH_CODE, DANISH_NAME, it)) }
		dto.rates.sterling?.let { currencyModels.add(CurrencyModel(STERLING_CODE, STERLING_NAME, it)) }
		dto.rates.mexican?.let { currencyModels.add(CurrencyModel(MEXICAN_CODE, MEXICAN_NAME, it)) }
		dto.rates.norwegian?.let { currencyModels.add(CurrencyModel(NORWEGIAN_CODE, NORWEGIAN_NAME, it)) }
		dto.rates.russian?.let { currencyModels.add(CurrencyModel(RUSSIAN_CODE, RUSSIAN_NAME, it)) }
		dto.rates.turkish?.let { currencyModels.add(CurrencyModel(TURKISH_CODE, TURKISH_NAME, it)) }
		dto.rates.american?.let { currencyModels.add(CurrencyModel(AMERICAN_CODE, AMERICAN_NAME, it)) }
		dto.rates.euro?.let { currencyModels.add(CurrencyModel(EURO_CODE, EURO_NAME, it)) }
		dto.rates.bulgarian?.let { currencyModels.add(CurrencyModel(BULGARIAN_CODE, BULGARIAN_NAME, it)) }
		dto.rates.polish?.let { currencyModels.add(CurrencyModel(POLISH_CODE, POLISH_NAME, it)) }

		return currencyModels
	}
}

