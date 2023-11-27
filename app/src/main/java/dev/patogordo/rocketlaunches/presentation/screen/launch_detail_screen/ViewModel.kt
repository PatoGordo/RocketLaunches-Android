package dev.patogordo.rocketlaunches.presentation.screen.launch_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.patogordo.rocketlaunches.common.Constants
import dev.patogordo.rocketlaunches.presentation.screen.launch_detail_screen.states.LaunchDetailState
import javax.inject.Inject

@HiltViewModel
class LaunchDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle
): ViewModel() {
  private val _state = mutableStateOf<LaunchDetailState>(LaunchDetailState())
  val state: State<LaunchDetailState> = _state

  init {
    savedStateHandle.get<String>(Constants.PARAM_LAUNCH_ID)?.let { launchId ->
      getLaunchDetail(launchId)
    }
  }

  private fun getLaunchDetail(launchId: String) {
    // TODO : Implements when launch detail api route is ready
  }
}