package ru.golden.currencyconverter.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.golden.currencyconverter.base.network.NetworkModule
import ru.golden.currencyconverter.feature.converter.ConverterActivity
import ru.golden.currencyconverter.feature.converter.di.ConverterActivityModule

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:47
 */
@Module(includes = [
	AndroidSupportInjectionModule::class,
	NetworkModule::class
])
interface ApplicationModule {

	@ActivityScope
	@ContributesAndroidInjector(modules = [ConverterActivityModule::class])
	fun converterActivityInjector(): ConverterActivity
}