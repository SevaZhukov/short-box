package com.siberiandroid.shortbox.navigation

import androidx.navigation.NavController
import androidx.navigation.compose.navigate

fun NavController.add(route: String): () -> Unit = {
	this.navigate(route)
}

fun NavController.replace(route: String): () -> Unit = {
	this.navigate(route) {
		popUpTo(this@replace.graph.id) { inclusive = true }
	}
}