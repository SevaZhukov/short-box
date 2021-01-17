package com.siberiandroid.shortbox.feature.onboarding.presentation

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun Onboarding(
	navigateToMain: () -> Unit,
	viewModel: OnboardingViewModel = getViewModel()
) {
	val onboardingPassed: Boolean by viewModel.onboardingPassed.observeAsState(false)

	if (onboardingPassed) {
		navigateToMain()
	}

	MaterialTheme {
		Text(text = "Onboarding")
		Button({ viewModel.passOnboarding() }) {
			Text("understand")
		}
	}
}