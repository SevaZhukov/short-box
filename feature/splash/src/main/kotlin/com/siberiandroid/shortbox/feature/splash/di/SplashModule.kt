package com.siberiandroid.shortbox.feature.splash.di

import com.siberiandroid.shortbox.feature.splash.domain.IsNewUserUceCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class SplashModule {

	@Binds
	abstract fun bindIsNewUserUseCase(
		isNewUserUceCase: IsNewUserUceCase
	): IsNewUserUceCase
}