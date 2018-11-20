package ru.golden.currencyconverter.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.golden.currencyconverter.base.ConverterApplication

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:46
 */
@Component(modules = [
	ApplicationModule::class
])
@ApplicationScope
interface ApplicationComponent : AndroidInjector<ConverterApplication> {

	@Component.Builder
	abstract class Builder : AndroidInjector.Builder<ConverterApplication>() {

		@BindsInstance
		abstract fun context(context: Context): Builder
	}

}