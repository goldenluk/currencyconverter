package ru.golden.currencyconverter.di

import javax.inject.Scope

/**
 * User: Matvei Khadzhiev
 * Date: 21.11.2018
 * Time: 0:48
 */
@Scope
@Retention
annotation class ApplicationScope

@Scope
@Retention
annotation class ActivityScope

@Scope
@Retention
annotation class FragmentScope