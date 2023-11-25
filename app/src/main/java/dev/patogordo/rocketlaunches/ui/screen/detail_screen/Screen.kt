package dev.patogordo.rocketlaunches.ui.screen.detail_screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable()
fun DetailScreen(name: String? = null) {
  val finalName = if (name?.length!! > 0) name else "Guest"

  Box(
    modifier = Modifier
      .fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Text(text = "Hello $finalName")
  }
}
