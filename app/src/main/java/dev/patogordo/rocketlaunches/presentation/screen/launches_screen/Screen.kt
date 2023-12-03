package dev.patogordo.rocketlaunches.presentation.screen.launches_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.composables.LaunchListItem
import dev.patogordo.rocketlaunches.presentation.composables.Loading
import dev.patogordo.rocketlaunches.presentation.ui.theme.ErrorMain

@Composable
fun LaunchesScreen(
  navController: NavController? = null,
  viewModel: LaunchesViewModel = hiltViewModel()
) {
  val state = viewModel.state.value

  Box(
    modifier = Modifier.fillMaxSize()
  ) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
      items(state.launches) {launch ->
        LaunchListItem(launch = launch, onItemClick = {
          navController?.navigate(
            Screen.LaunchDetailScreen.withPositionalArgs(
              launch.id.toString()
            )
          )
        })

        Spacer(modifier = Modifier.height(16.dp))
      }
    }

    if (state.error.isNotBlank()) {
      Text(
        text = state.error,
        color = ErrorMain,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp)
          .align(Alignment.Center)
      )
    }

    if (state.isLoading) {
      Loading("Loading launches..")
    }
  }
}

@Preview
@Composable
fun PreviewLaunchesScreen() {
  LaunchesScreen()
}
