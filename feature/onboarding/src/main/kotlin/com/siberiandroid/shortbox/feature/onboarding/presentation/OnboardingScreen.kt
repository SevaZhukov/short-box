package com.siberiandroid.shortbox.feature.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material.icons.outlined.FiberManualRecord
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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

	ShortboxTheme {
		/*Text(text = "Onboarding")
		Button({ viewModel.passOnboarding() }) {
			Text("understand")
		}*/
		Surface(modifier = Modifier.fillMaxSize()) {
			Scaffold(
				bodyContent = {
					Column {
						Text(
							text = "Слайд 1",
							style = MaterialTheme.typography.subtitle1
						)
						Spacer(modifier = Modifier.height(24.dp))
						Text("Текст 1")
					}
				},
				bottomBar = {
					Surface(
//						elevation = 3.dp
					) {
						Row(
							modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
						) {
							OutlinedButton(
								modifier = Modifier.weight(1f),
								onClick = {}
							) {
								Text("Назад")
							}
							Spacer(modifier = Modifier.width(16.dp))
							PageIndicator(
								pagesCount = 4,
								currentPageIndex = 0
							)
							Button(
								modifier = Modifier.weight(1f),
								onClick = {}
							) {
								Text("Дальше")
							}
						}
					}
				}
			)
		}
	}
}


@Composable
private fun PageIndicator(pagesCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
	Row(
		modifier = modifier
			.wrapContentWidth(align = Alignment.CenterHorizontally)
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