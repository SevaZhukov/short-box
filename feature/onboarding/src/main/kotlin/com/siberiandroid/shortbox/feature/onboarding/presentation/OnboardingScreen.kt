package com.siberiandroid.shortbox.feature.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material.icons.outlined.FiberManualRecord
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siberiandroid.shortbox.shared.ui.ShortboxTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun OnboardingScreen(
	navigateToMain: () -> Unit,
	viewModel: OnboardingViewModel = getViewModel()
) {
	val onboardingPassed: Boolean by viewModel.onboardingPassed.observeAsState(false)

	if (onboardingPassed) {
		navigateToMain()
	}

	val texts = listOf("текст 1", "текст 2", "текст 3", "текст 4")

	var currentSlideIndex by savedInstanceState { 0 }

	ShortboxTheme {
		Scaffold(
			modifier = Modifier.fillMaxWidth(),
			bodyContent = {
				SlideBody(text = texts[currentSlideIndex])
			},
			bottomBar = {
				Column(modifier = Modifier.fillMaxWidth()) {
					SlideIndicator(
						pagesCount = texts.size,
						currentPageIndex = currentSlideIndex
					)
					SlideButtons(
						onPreviousPressed = { currentSlideIndex-- },
						onNextPressed = { currentSlideIndex++ }
					)
				}
			}
		)
	}
}

@Composable
private fun SlideBody(text: String) {
	Column {
		Text(
			text = text,
			style = MaterialTheme.typography.subtitle1
		)
	}
}

@Composable
private fun SlideIndicator(pagesCount: Int, currentPageIndex: Int) {
	Row(
		modifier = Modifier.fillMaxWidth()
			.padding(horizontal = 16.dp, vertical = 16.dp)
	) {
		for (pageIndex in 0 until pagesCount) {
			val asset = if (currentPageIndex == pageIndex) {
				Icons.Filled.FiberManualRecord
			} else {
				Icons.Outlined.FiberManualRecord
			}
			Icon(
				imageVector = asset,
				tint = MaterialTheme.colors.primary
			)
		}
	}
}

@Composable
private fun SlideButtons(
	onPreviousPressed: () -> Unit,
	onNextPressed: () -> Unit
) {
	Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
		OutlinedButton(
			modifier = Modifier.weight(1f),
			onClick = { onPreviousPressed() }
		) {
			Text("Назад")
		}
		Spacer(modifier = Modifier.width(16.dp))
		Button(
			modifier = Modifier.weight(1f),
			onClick = { onNextPressed() }
		) {
			Text("Дальше")
		}
	}
}