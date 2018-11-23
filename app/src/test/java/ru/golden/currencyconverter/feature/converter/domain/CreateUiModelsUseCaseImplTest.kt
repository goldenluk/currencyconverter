package ru.golden.currencyconverter.feature.converter.domain

import com.google.common.truth.Truth.*
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.After
import org.junit.Before
import org.junit.Test
import ru.golden.currencyconverter.feature.converter.domain.converters.UiModelConverter

class CreateUiModelsUseCaseImplTest {

	private val converter: UiModelConverter = mock()
	private lateinit var useCase: CreateUiModelsUseCase

	@Before
	fun setUp() {
		useCase = CreateUiModelsUseCaseImpl(converter)
	}

	@After
	fun tearDown() {
		verifyNoMoreInteractions(converter)
	}

	@Test
	fun `WHEN currency models list is empty EXPECT one uiModel with base values`() {
		val baseValue = 10.0

		val result = useCase.execute(emptyList(), baseValue)

		assertThat(result.size).isEqualTo(1)
		assertThat(result.first().value.get()).isEqualTo(baseValue)
		assertThat(result.first().code).isEqualTo("EUR")
	}

	@Test
	fun `WHEN currency models list contains two models EXPECT three uiModels`() {
		val baseValue = 10.0

		val currencyModels = listOf(FIRST_CURRENCY_MODEL, SECOND_CURRENCY_MODEL)

		whenever(converter.convert(FIRST_CURRENCY_MODEL, baseValue)).thenReturn(FIRST_UI_MODEL)
		whenever(converter.convert(SECOND_CURRENCY_MODEL, baseValue)).thenReturn(SECOND_UI_MODEL)

		val result = useCase.execute(currencyModels, baseValue)

		assertThat(result.size).isEqualTo(3)
		assertThat(result.first().value.get()).isEqualTo(baseValue)
		assertThat(result[1]).isEqualTo(FIRST_UI_MODEL)
		assertThat(result[2]).isEqualTo(SECOND_UI_MODEL)

		verify(converter).convert(FIRST_CURRENCY_MODEL, baseValue)
		verify(converter).convert(SECOND_CURRENCY_MODEL, baseValue)
	}
}