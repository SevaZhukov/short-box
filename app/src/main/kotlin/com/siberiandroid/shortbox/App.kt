package com.siberiandroid.shortbox

import android.app.Application
import com.siberiandroid.shortbox.feature.onboarding.di.onboardingModule
import com.siberiandroid.shortbox.feature.splash.di.splashModule
import com.siberiandroid.shortbox.shared.preferences.di.preferencesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger()
			androidContext(this@App)
			modules(
				preferencesModule,
				splashModule,
				onboardingModule
			)
		}
	}
}