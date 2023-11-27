package dev.patogordo.rocketlaunches.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.patogordo.rocketlaunches.common.Constants
import dev.patogordo.rocketlaunches.presentation.screen.launch_detail_screen.DetailScreen
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.HomeScreen
import dev.patogordo.rocketlaunches.presentation.screen.launches_screen.LaunchesScreen
import dev.patogordo.rocketlaunches.presentation.screen.news_screen.NewsScreen

@Composable
fun Navigation() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Screen.HomeScreen.route
  ) {
    composable(
      route = Screen.HomeScreen.route,
    ) {
      HomeScreen(navController = navController)
    }

    composable(
      route = Screen.LaunchesScreen.route
    ) {
      LaunchesScreen(
        navController = navController
      )
    }

    composable(
      route = Screen.NewsScreen.route
    ) {
      NewsScreen()
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
      DetailScreen(launchId = entry.arguments?.getString(Constants.PARAM_LAUNCH_ID))
    }
  }
}

