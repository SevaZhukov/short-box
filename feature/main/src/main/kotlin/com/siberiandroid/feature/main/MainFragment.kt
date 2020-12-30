package com.siberiandroid.feature.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView

class MainFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return ComposeView(requireContext()).apply {
			return inflater.inflate(R.layout.fragment_main, container, false).apply {
				findViewById<ComposeView>(R.id.compose).setContent {
					Text(text = "Hello world.")
				}
			}
		}
	}
}