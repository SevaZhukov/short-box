package com.siberiandroid.shortbox.feature.onboarding.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siberiandroid.shortbox.feature.onboarding.domain.PassOnboardingUseCase
import kotlinx.coroutines.launch

class OnboardingViewModel(
	private val passOnboardingUseCase: PassOnboardingUseCase
) : ViewModel() {

	private val _onboardingPassed = MutableLiveData<Boolean>()
	val onboardingPassed: LiveData<Boolean> = _onboardingPassed

	fun passOnboarding() {
		viewModelScope.launch {
			passOnboardingUseCase()
			_onboardingPassed.value = true
		}
	}
}