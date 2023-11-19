package dev.patogordo.rocketlaunches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.patogordo.rocketlaunches.ui.navigation.Navigation

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      Navigation()
    }
  }
}
