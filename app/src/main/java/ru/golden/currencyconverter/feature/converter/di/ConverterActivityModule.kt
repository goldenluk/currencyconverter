package ru.golden.currencyconverter.feature.converter.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.golden.currencyconverter.di.FragmentScope
import ru.golden.currencyconverter.feature.converter.presentation.ui.ConverterFragment

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 20:39
 */
@Module
interface ConverterActivityModule {

	@FragmentScope
	@ContributesAndroidInjector(modules = [ConverterModule::class])
	fun converterFragmentInjector(): ConverterFragment
}