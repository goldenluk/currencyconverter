package ru.golden.currencyconverter.base

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ru.golden.currencyconverter.di.DaggerApplicationComponent
import javax.inject.Inject

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:40
 */
class ConverterApplication : Application(), HasActivityInjector {

	@Inject
	lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

	override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

	override fun onCreate() {
		super.onCreate()
		initDagger()
	}

	private fun initDagger() {
		DaggerApplicationComponent
			.builder()
			.context(this)
			.create(this)
			.inject(this)
	}
}