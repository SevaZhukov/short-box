package com.siberiandroid.shortbox.shared.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.siberiandroid.shortbox.shared.preferences.data.reposiotry.PreferencesRepositoryImpl
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository
import org.koin.dsl.module

val preferencesModule = module {

	fun createDataStore(context: Context): DataStore<Preferences> =
		context.createDataStore("settings")

	single { createDataStore(get()) }

	factory<PreferencesRepository> { PreferencesRepositoryImpl(get()) }
}