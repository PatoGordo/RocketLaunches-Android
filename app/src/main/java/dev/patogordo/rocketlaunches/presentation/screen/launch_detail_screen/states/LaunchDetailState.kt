package dev.patogordo.rocketlaunches.presentation.screen.launch_detail_screen.states

import dev.patogordo.rocketlaunches.domain.model.Launch

data class LaunchDetailState (
  val isLoading: Boolean = false,
  val launch: Launch? = null,
  val error: String = ""
)