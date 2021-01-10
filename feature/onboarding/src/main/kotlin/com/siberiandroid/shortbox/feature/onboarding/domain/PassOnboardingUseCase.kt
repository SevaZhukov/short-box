package com.siberiandroid.shortbox.feature.onboarding.domain

import com.siberiandroid.shortbox.shared.preferences.domain.model.PreferencesKeys
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository

class PassOnboardingUseCase(
	private val preferencesRepository: PreferencesRepository
) {

	suspend operator fun invoke() {
		preferencesRepository.setBoolean(PreferencesKeys.ONBOARDING_PASSED, true)
	}
}