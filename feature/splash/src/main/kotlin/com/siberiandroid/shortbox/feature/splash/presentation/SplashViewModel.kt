package com.siberiandroid.shortbox.feature.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

	private val _isNewUser = MutableLiveData<Boolean>()
	val isNewUser: LiveData<Boolean> = _isNewUser

	init {
		_isNewUser.value = true
	}
}