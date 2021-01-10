package com.siberiandroid.shortbox.feature.splash.di

import com.siberiandroid.shortbox.feature.splash.domain.IsNewUserUceCase
import com.siberiandroid.shortbox.feature.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
	factory { IsNewUserUceCase(get()) }

	viewModel { SplashViewModel(get()) }
}