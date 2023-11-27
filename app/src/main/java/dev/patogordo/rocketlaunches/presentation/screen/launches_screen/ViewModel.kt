package dev.patogordo.rocketlaunches.presentation.screen.launches_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.patogordo.rocketlaunches.common.Resource
import dev.patogordo.rocketlaunches.domain.use_case.launches.list_incoming.ListIncomingUseCase
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.states.LaunchListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
  private val listIncomingUseCase: ListIncomingUseCase
): ViewModel() {
  private val _launchState = mutableStateOf<LaunchListState>(LaunchListState())
  val state: State<LaunchListState> = _launchState

  init {
    getIncomingLaunches()
  }

  private fun getIncomingLaunches() {
    listIncomingUseCase().onEach { result ->
      when (result) {
        is Resource.Success -> {
          _launchState.value = LaunchListState(
            launches = result.data ?: emptyList()
          )
        }

        is Resource.Error -> {
          _launchState.value = LaunchListState(
            error = result.message ?: "An unexpected error occurred"
          )
        }

        is Resource.Loading -> {
          _launchState.value = LaunchListState(isLoading = true)
        }
      }
    }.launchIn(viewModelScope)
  }

}