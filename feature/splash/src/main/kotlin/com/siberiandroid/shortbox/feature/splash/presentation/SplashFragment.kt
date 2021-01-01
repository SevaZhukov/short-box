package com.siberiandroid.shortbox.feature.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.siberiandroid.shortbox.feature.splash.R
import com.siberiandroid.shortbox.shared.navigation.navigate

class SplashFragment : Fragment() {

	private val viewModel: SplashViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel.isNewUser.observe(this) {
			if (it) {
				navigate(R.id.action_splashFragment_to_onboardingFragment)
			} else {
				navigate(R.id.action_splashFragment_to_mainFragment)
			}
		}
	}
}