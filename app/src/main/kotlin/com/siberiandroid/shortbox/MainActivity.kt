package com.siberiandroid.shortbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.setContent
import com.siberiandroid.shortbox.navigation.GlobalNavigationGraph

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			GlobalNavigationGraph()
		}
	}
}