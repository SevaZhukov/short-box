package com.siberiandroid.shortbox.shared.preferences.domain.model

import androidx.datastore.preferences.core.preferencesKey

object PreferencesKeys {

	val ONBOARDING_PASSED = preferencesKey<Boolean>("onboarding_passed")
}