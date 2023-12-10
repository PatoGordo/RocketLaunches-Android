package dev.patogordo.rocketlaunches.presentation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.House
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
  val route: String,
  val title: String = "",
  val defaultIcon: ImageVector = Icons.Outlined.QuestionMark,
  val activeIcon: ImageVector = Icons.Filled.QuestionMark,
) {
  data object HomeScreen : Screen(
    route = "index_screen",
    title =  "Home",
    defaultIcon = Icons.Outlined.House,
    activeIcon = Icons.Filled.House,
  )
  data object LaunchesScreen : Screen(
    route = "launches_screen",
    title = "Launches",
    defaultIcon = Icons.Outlined.RocketLaunch,
    activeIcon = Icons.Filled.RocketLaunch,
  )
  data object NewsScreen : Screen(
    route = "news_screen",
    title = "News",
    defaultIcon = Icons.Outlined.Article,
    activeIcon = Icons.Outlined.Article,
  )
  data object ProfileScreen : Screen(
    route = "profile_screen",
    title = "Profile",
    defaultIcon = Icons.Outlined.Person,
    activeIcon = Icons.Filled.Person,
  )
  data object LaunchDetailScreen : Screen(
    route = "launch_detail_screen"
  )

  fun withPositionalArgs(vararg args : String) : String {
    return buildString {
      append(route)
      args.forEach { arg ->
        append("/$arg")
      }
    }
  }

  fun withQueryArgs(vararg args: QueryArg): String {
    return buildString {
      append(route)
      if (args.isNotEmpty()) {
        append("?${args[0].name}=${args[0].value}")
        for (i in 1 until args.size) {
          append("&${args[i].name}=${args[i].value}")
        }
      }
    }
  }
}

data class QueryArg(val name: String, val value: String)

val bottomNavigationBarItems = listOf(
  Screen.HomeScreen,
  Screen.LaunchesScreen,
  Screen.NewsScreen,
  Screen.ProfileScreen,
)
