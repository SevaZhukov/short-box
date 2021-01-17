package com.siberiandroid.shortbox.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.siberiandroid.shortbox.feature.main.Main
import com.siberiandroid.shortbox.feature.onboarding.presentation.Onboarding
import com.siberiandroid.shortbox.feature.splash.presentation.Splash
import org.koin.androidx.compose.getViewModel

object GlobalDestinations {

	const val SPLASH = "splash"
	const val MAIN = "main"
	const val ONBOARDING = "onboarding"
}

class GlobalActions(navController: NavController) {

	val navigateToMain = { navController.navigate(GlobalDestinations.MAIN) }
	val navigateToOnboarding = { navController.navigate(GlobalDestinations.ONBOARDING) }
}

@Composable
fun GlobalNavigationGraph() {
	val navController = rememberNavController()

	val actions = remember(navController) { GlobalActions(navController) }

	NavHost(navController, GlobalDestinations.SPLASH) {
		composable(GlobalDestinations.SPLASH) {
			Splash(actions.navigateToMain, actions.navigateToOnboarding)
		}
		composable(GlobalDestinations.ONBOARDING) {
			Onboarding(actions.navigateToMain)
		}
		composable(GlobalDestinations.MAIN) {
			Main()
		}
	}
}