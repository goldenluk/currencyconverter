package ru.golden.currencyconverter.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.golden.currencyconverter.feature.converter.ConverterActivity

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:47
 */
@Module(includes = [
	AndroidSupportInjectionModule::class
])
interface ApplicationModule {

	@ActivityScope
	@ContributesAndroidInjector
	fun converterActivityInjector(): ConverterActivity
}