package com.siberiandroid.shortbox.shared.preferences.domain.reposiotry

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {

	suspend fun get(key: Preferences.Key<String>): String?

	suspend fun set(key: Preferences.Key<String>, value: String)
}