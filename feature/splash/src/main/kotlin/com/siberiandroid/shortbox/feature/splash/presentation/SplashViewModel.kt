package com.siberiandroid.shortbox.feature.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siberiandroid.shortbox.feature.splash.domain.IsOnboardingPassedUceCase
import kotlinx.coroutines.launch

class SplashViewModel(
	private val isOnboardingPassedUceCase: IsOnboardingPassedUceCase
) : ViewModel() {

	private val _isOnboardingPassed = MutableLiveData<Boolean>()
	val isOnboardingPassed: LiveData<Boolean> = _isOnboardingPassed

	init {
		viewModelScope.launch {
			_isOnboardingPassed.value = isOnboardingPassedUceCase()
		}
	}
}