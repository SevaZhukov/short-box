package com.siberiandroid.shortbox.shared.preferences.data.reposiotry

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
	private val dataStore: DataStore<Preferences>
) : PreferencesRepository {

	override suspend fun get(key: Preferences.Key<String>): String? = dataStore.data.map { it[key] }.firstOrNull()

	override suspend fun set(key: Preferences.Key<String>, value: String) {
		dataStore.edit { it[key] = value }
	}
}