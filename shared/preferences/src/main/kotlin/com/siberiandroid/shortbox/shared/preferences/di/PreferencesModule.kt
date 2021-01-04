package com.siberiandroid.shortbox.shared.preferences.di

import android.content.Context
import androidx.datastore.preferences.createDataStore
import com.siberiandroid.shortbox.shared.preferences.data.reposiotry.PreferencesRepositoryImpl
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class PreferencesModule {

	companion object {

		@Singleton
		@Provides
		fun provideDataStore(@ApplicationContext context: Context) = context.createDataStore("settings")
	}

	@Binds
	abstract fun bindPreferencesRepository(preferencesRepository: PreferencesRepositoryImpl): PreferencesRepository
}