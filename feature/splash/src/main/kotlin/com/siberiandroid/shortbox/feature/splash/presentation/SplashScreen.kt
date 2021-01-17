package com.siberiandroid.shortbox.feature.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun SplashScreen(
	navigateToMain: () -> Unit,
	navigateToOnboarding: () -> Unit,
	viewModel: SplashViewModel = getViewModel()
) {
	val isOnboardingPassed: Boolean? by viewModel.isOnboardingPassed.observeAsState()

	if (isOnboardingPassed ?: return) {
		navigateToMain()
	} else {
		navigateToOnboarding()
	}
}