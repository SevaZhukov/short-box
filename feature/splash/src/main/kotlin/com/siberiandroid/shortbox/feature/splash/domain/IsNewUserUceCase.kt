package com.siberiandroid.shortbox.feature.splash.domain

import com.siberiandroid.shortbox.shared.preferences.domain.model.PreferencesKeys.ONBOARDING_PASSED
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository

class IsNewUserUceCase(
	private val preferencesRepository: PreferencesRepository
) {

	suspend operator fun invoke(): Boolean =
		preferencesRepository.getBoolean(ONBOARDING_PASSED) != true
}