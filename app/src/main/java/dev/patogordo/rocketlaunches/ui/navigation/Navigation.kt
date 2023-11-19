package dev.patogordo.rocketlaunches.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.patogordo.rocketlaunches.view.DetailScreen
import dev.patogordo.rocketlaunches.view.MainScreen

@Composable
fun Navigation() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Screen.MainScreen.route
  ) {
    composable(
      route = Screen.MainScreen.route,
    ) {
      MainScreen(navController = navController)
    }

    composable(
      route = Screen.DetailScreen.route + "?name={name}",
      arguments = listOf(
        navArgument("name") {
          type = NavType.StringType
          defaultValue = "Guest"
          nullable = true
        }
      )
    ) {
      entry ->
        DetailScreen(name = entry.arguments?.getString("name"))
    }
  }
}

