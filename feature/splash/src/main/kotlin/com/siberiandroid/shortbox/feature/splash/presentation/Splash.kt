package com.siberiandroid.shortbox.feature.splash.presentation

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel

@Composable
fun Splash(
	navigateToMain: () -> Unit,
	navigateToOnboarding: () -> Unit,
	viewModel: SplashViewModel = getViewModel()
) {
	viewModel.isOnboardingPassed.observeForever {
		if (it) {
			navigateToMain()
		} else {
			navigateToOnboarding()
		}
	}
}