package com.siberiandroid.shortbox.feature.splash.di

import com.siberiandroid.shortbox.feature.splash.domain.IsOnboardingPassedUceCase
import com.siberiandroid.shortbox.feature.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
	factory { IsOnboardingPassedUceCase(get()) }

	viewModel { SplashViewModel(get()) }
}