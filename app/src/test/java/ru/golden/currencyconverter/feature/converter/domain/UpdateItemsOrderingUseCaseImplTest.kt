package ru.golden.currencyconverter.feature.converter.domain

import com.google.common.truth.Truth.*
import org.junit.Test
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterItemUiModel

class UpdateItemsOrderingUseCaseImplTest {

	private val useCase = UpdateItemsOrderingUseCaseImpl()

	@Test
	fun `WHEN uiModels contains two elements and second item is selected EXPECT swap between second and first`() {
		val uiModels = ArrayList<ConverterItemUiModel>()
		uiModels.add(FIRST_UI_MODEL)
		uiModels.add(SECOND_UI_MODEL)

		val result = useCase.execute("second code", uiModels)

		assertThat(result.size).isEqualTo(uiModels.size)
		assertThat(result.first()).isEqualTo(SECOND_UI_MODEL)
		assertThat(result[1]).isEqualTo(FIRST_UI_MODEL)
	}
}