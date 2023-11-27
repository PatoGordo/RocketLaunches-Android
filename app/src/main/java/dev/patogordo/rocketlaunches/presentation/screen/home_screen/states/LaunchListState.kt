package dev.patogordo.rocketlaunches.presentation.screen.home_screen.states

import dev.patogordo.rocketlaunches.domain.model.Launch

data class LaunchListState(
  val isLoading: Boolean = false,
  val launches: List<Launch> = emptyList(),
  val error: String = ""
)
