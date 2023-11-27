package dev.patogordo.rocketlaunches.presentation.screen

sealed class Screen(val route: String) {
  object HomeScreen : Screen("index_screen")
  object LaunchesScreen : Screen("launches_screen")
  object NewsScreen : Screen("news_screen")
  object LaunchDetailScreen : Screen("launch_detail_screen")

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
