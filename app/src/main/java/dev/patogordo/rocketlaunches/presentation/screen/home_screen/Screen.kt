package dev.patogordo.rocketlaunches.presentation.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base300

@Composable
fun HomeScreen(navController: NavController? = null) {

  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .background(Base300)
      .fillMaxSize()
      .padding(horizontal = 32.dp)
  )  {
    Button(
      onClick = {
        navController?.navigate(Screen.LaunchesScreen.route)
      }
    ) {
      Text("GO TO LAUNCHES SCREEN")
    }
  }
}

@Preview
@Composable
fun HomeScreenPreview() {
  HomeScreen()
}
