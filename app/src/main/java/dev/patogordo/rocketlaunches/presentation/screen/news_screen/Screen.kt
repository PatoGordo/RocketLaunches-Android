package dev.patogordo.rocketlaunches.presentation.screen.news_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base300

@Composable
fun NewsScreen() {
  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .background(Base300)
      .fillMaxSize()
      .padding(horizontal = 32.dp)
  )  {
  }
}
