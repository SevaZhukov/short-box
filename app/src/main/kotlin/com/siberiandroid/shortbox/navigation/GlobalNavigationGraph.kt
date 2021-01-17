package com.siberiandroid.shortbox.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siberiandroid.shortbox.feature.main.MainScreen
import com.siberiandroid.shortbox.feature.onboarding.presentation.OnboardingScreen
import com.siberiandroid.shortbox.feature.splash.presentation.SplashScreen

object GlobalDestinations {

	const val SPLASH = "splash"
	const val MAIN = "main"
	const val ONBOARDING = "onboarding"
}

class GlobalActions(navController: NavController) {

	val navigateToMain = navController.replace(GlobalDestinations.MAIN)
	val navigateToOnboarding = navController.replace(GlobalDestinations.ONBOARDING)
}

@Composable
fun GlobalNavigationGraph() {
	val navController = rememberNavController()

	val actions = remember(navController) { GlobalActions(navController) }

	NavHost(navController, GlobalDestinations.SPLASH) {
		composable(GlobalDestinations.SPLASH) {
			SplashScreen(actions.navigateToMain, actions.navigateToOnboarding)
		}
		composable(GlobalDestinations.ONBOARDING) {
			OnboardingScreen(actions.navigateToMain)
		}
		composable(GlobalDestinations.MAIN) {
			MainScreen()
		}
	}
}