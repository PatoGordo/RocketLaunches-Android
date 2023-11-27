package dev.patogordo.rocketlaunches.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.patogordo.rocketlaunches.presentation.screen.Navigation
import dev.patogordo.rocketlaunches.presentation.ui.theme.RocketLaunchesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      RocketLaunchesTheme (
        darkTheme = true,
      ) {
        Navigation()
      }
    }
  }
}
