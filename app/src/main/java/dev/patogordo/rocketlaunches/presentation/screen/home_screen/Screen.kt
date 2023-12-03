package dev.patogordo.rocketlaunches.presentation.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.patogordo.rocketlaunches.presentation.composables.LaunchListItem
import dev.patogordo.rocketlaunches.presentation.composables.Loading
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base300
import dev.patogordo.rocketlaunches.presentation.ui.theme.ErrorMain

@Composable
fun HomeScreen(
  navController: NavController? = null,
  viewModel: HomeViewModel = hiltViewModel()
) {
  val state = viewModel.state.value

  Column(
    modifier = Modifier
      .background(Base300)
      .fillMaxSize()
      .padding(16.dp)
  )  {
    if (state.launches.isNotEmpty()) {
      LaunchListItem(
        launch = state.launches.first(),
        onItemClick = {
          navController?.navigate(
            Screen.LaunchDetailScreen.withPositionalArgs(
              state.launches.first().id.toString()
            )
          )
        }
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (state.error.isNotBlank()) {
      Text(
        text = state.error,
        color = ErrorMain,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp)
          .align(Alignment.CenterHorizontally)
      )
    }

    if (state.isLoading) {
      Loading("Loading launches..")
    }

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
