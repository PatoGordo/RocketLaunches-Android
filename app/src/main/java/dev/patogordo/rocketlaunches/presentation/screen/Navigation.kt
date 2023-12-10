package dev.patogordo.rocketlaunches.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.patogordo.rocketlaunches.common.Constants
import dev.patogordo.rocketlaunches.presentation.composables.BottomNavigationBar
import dev.patogordo.rocketlaunches.presentation.screen.launch_detail_screen.DetailScreen
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.HomeScreen
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.HomeViewModel
import dev.patogordo.rocketlaunches.presentation.screen.launches_screen.LaunchesScreen
import dev.patogordo.rocketlaunches.presentation.screen.launches_screen.LaunchesViewModel
import dev.patogordo.rocketlaunches.presentation.screen.news_screen.NewsScreen
import dev.patogordo.rocketlaunches.presentation.screen.news_screen.NewsViewModel

@Composable
fun Navigation() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Screen.HomeScreen.route,
    modifier = Modifier
      .fillMaxSize()
  ) {
    composable(
      route = Screen.HomeScreen.route,
    ) {
      val viewModel = hiltViewModel<HomeViewModel>()

      HomeScreen(
        navController = navController,
      )
    }

    composable(
      route = Screen.LaunchesScreen.route
    ) {
      val viewModel = hiltViewModel<LaunchesViewModel>()
      val state = viewModel.state

      LaunchesScreen(
        navController = navController,
        state = state
      )
    }

    composable(
      route = Screen.NewsScreen.route
    ) {
      val viewModel = hiltViewModel<NewsViewModel>()
      val state = viewModel.state

      NewsScreen(
        navController = navController,
        state = state,
        openURLInBrowser = { viewModel.openURLInBrowser(it) }
      )
    }

    composable(
      route = Screen.LaunchDetailScreen.route + "/{${Constants.PARAM_LAUNCH_ID}}",
      arguments = listOf(
        navArgument(Constants.PARAM_LAUNCH_ID) {
          type = NavType.StringType
          nullable = true
        }
      )
    ) {
        entry ->
      DetailScreen(
        launchId = entry.arguments?.getString(Constants.PARAM_LAUNCH_ID)
      )
    }
  }
}

