package com.siberiandroid.shortbox.feature.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siberiandroid.shortbox.feature.splash.domain.IsNewUserUceCase
import kotlinx.coroutines.launch

class SplashViewModel(
	private val isNewUserUceCase: IsNewUserUceCase
) : ViewModel() {

	private val _isNewUser = MutableLiveData<Boolean>()
	val isNewUser: LiveData<Boolean> = _isNewUser

	init {
		viewModelScope.launch {
			_isNewUser.value = isNewUserUceCase()
		}
	}
}