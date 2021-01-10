package com.siberiandroid.shortbox.feature.onboarding.di

import com.siberiandroid.shortbox.feature.onboarding.domain.PassOnboardingUseCase
import com.siberiandroid.shortbox.feature.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
	factory { PassOnboardingUseCase(get()) }

	viewModel { OnboardingViewModel(get()) }
}