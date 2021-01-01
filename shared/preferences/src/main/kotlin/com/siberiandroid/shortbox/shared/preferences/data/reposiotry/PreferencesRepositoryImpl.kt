package com.siberiandroid.shortbox.shared.preferences.data.reposiotry

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class PreferencesRepositoryImpl(private val dataStore: DataStore<Preferences>) : PreferencesRepository {

	override suspend fun get(key: Preferences.Key<String>): Flow<String> = dataStore.data.mapNotNull { it[key] }

	override suspend fun set(key: Preferences.Key<String>, value: String) {
		dataStore.edit { it[key] = value }
	}
}