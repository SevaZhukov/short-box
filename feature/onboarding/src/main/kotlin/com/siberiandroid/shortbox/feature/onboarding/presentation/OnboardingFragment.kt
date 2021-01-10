package com.siberiandroid.shortbox.feature.onboarding.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.siberiandroid.shortbox.feature.onboarding.R
import com.siberiandroid.shortbox.shared.navigation.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment : Fragment() {

	private val viewModel: OnboardingViewModel by viewModel()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return ComposeView(requireContext()).apply {
			setContent {
				OnboardingFragmentScreen()
			}
		}
	}

	@Composable
	fun OnboardingFragmentScreen() {
		val onboardingPassed: Boolean by viewModel.onboardingPassed.observeAsState(false)

		if (onboardingPassed) {
			navigate(R.id.action_onboardingFragment_to_mainFragment)
		}

		MaterialTheme {
			Text(text = "Onboarding")
			Button({ viewModel.passOnboarding() }) {
				Text("understand")
			}
		}
	}
}