package com.siberiandroid.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.siberiandroid.shortbox.shared.navigation.NavDestination
import com.siberiandroid.shortbox.shared.navigation.navigate

class SplashFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		navigate(R.id.action_splashFragment_to_mainFragment, R.id.host_global)
		return inflater.inflate(R.layout.fragment_splash, container, false)
	}
}