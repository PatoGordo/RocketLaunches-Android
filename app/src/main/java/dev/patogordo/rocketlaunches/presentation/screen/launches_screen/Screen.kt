package dev.patogordo.rocketlaunches.presentation.screen.launches_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.patogordo.rocketlaunches.R
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.composables.LaunchListItem
import dev.patogordo.rocketlaunches.presentation.composables.Loading
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.states.LaunchListState
import dev.patogordo.rocketlaunches.presentation._preview.previewLaunchData
import dev.patogordo.rocketlaunches.presentation.composables.BottomNavigationBar
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base300
import dev.patogordo.rocketlaunches.presentation.ui.theme.ErrorMain

@Composable
fun LaunchesScreen(
  state: State<LaunchListState>,
  navController: NavController? = null
) {
  val state = state.value

  if (state.isLoading) {
    Loading("Loading launches..")
  }

  BottomNavigationBar(
    navController = navController ?: rememberNavController(),
    activeItem = Screen.LaunchesScreen,
  ) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp)
    ) {
      item {
        Spacer(modifier = Modifier.height(24.dp))

        Image(
          painter = painterResource(
            id = R.drawable.rocketlaunches_logo_landscape
          ),
          contentDescription = "Rocket Launches Logo",
          modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
          text = "   Incoming Launches   ",
          color = Color.White,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))
      }

      items(state.launches) { launch ->
        LaunchListItem(launch = launch, onItemClick = {
          navController?.navigate(
            Screen.LaunchDetailScreen.withPositionalArgs(
              launch.id.toString()
            )
          )
        })

        Spacer(modifier = Modifier.height(16.dp))
      }

      item {
        if (state.error.isNotBlank()) {
          Text(
            text = state.error,
            color = ErrorMain,
            textAlign = TextAlign.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 16.dp)
          )
        }

        Spacer(modifier = Modifier.height(it))
      }
    }
  }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun PreviewLaunchesScreen() {
  LaunchesScreen(
    state = mutableStateOf(LaunchListState(
      launches = listOf(
        previewLaunchData
      )
    )),
  )
}
