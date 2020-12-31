package com.siberiandroid.shortbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.siberiandroid.shortbox.feature.splash.presentation.SplashViewModel

class SplashFragment : Fragment() {

	private val viewModel: SplashViewModel by viewModels()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return ComposeView(requireContext()).apply {
			setContent {
				Text(text = "Splash")
			}
		}
	}
}