package com.siberiandroid.shortbox.feature.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.navGraphViewModels

class OnboardingFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return ComposeView(requireContext()).apply {
			setContent {
				MaterialTheme {
					Text(text = "Onboarding")
				}
			}
		}
	}
}