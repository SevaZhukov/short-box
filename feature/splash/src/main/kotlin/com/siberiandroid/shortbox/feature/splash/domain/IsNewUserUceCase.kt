package com.siberiandroid.shortbox.feature.splash.domain

import com.siberiandroid.shortbox.shared.preferences.domain.model.PreferencesKeys
import com.siberiandroid.shortbox.shared.preferences.domain.reposiotry.PreferencesRepository
import javax.inject.Inject

class IsNewUserUceCase @Inject constructor(
	private val preferencesRepository: PreferencesRepository
) {

	suspend operator fun invoke(): Boolean =
		preferencesRepository.get(PreferencesKeys.USERNAME) != null
}