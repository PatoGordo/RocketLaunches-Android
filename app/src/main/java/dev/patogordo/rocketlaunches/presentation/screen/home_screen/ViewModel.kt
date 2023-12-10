package dev.patogordo.rocketlaunches.presentation.screen.home_screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.patogordo.rocketlaunches.common.Resource
import dev.patogordo.rocketlaunches.domain.use_case.launches.list_incoming.ListIncomingUseCase
import dev.patogordo.rocketlaunches.domain.use_case.news.list_recent.ListRecentUseCase
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.states.LaunchListState
import dev.patogordo.rocketlaunches.presentation.screen.home_screen.states.NewsListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class HomeViewModel @Inject constructor(
  private val listIncomingUseCase: ListIncomingUseCase,
  private val listRecentUseCase: ListRecentUseCase,
  @ApplicationContext private val mContext: Context,
): ViewModel() {
  private val _launchState = mutableStateOf(LaunchListState())
  val launchState: State<LaunchListState> = _launchState

  private val _newsState = mutableStateOf(NewsListState())
  val newsState: State<NewsListState> = _newsState

  init {
    getIncomingLaunches()
    getBreakingNews()
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

  private fun getBreakingNews() {
    listRecentUseCase.invoke().onEach { result ->
      when(result) {
        is Resource.Success -> {
          _newsState.value = NewsListState(
            news = result.data ?: emptyList()
          )
        }

        is Resource.Loading -> {
          _newsState.value = NewsListState(
            isLoading = true
          )
        }

        is Resource.Error -> {
          _newsState.value = NewsListState(
            error = result.message ?: "Un unexpected error has occurred!"
          )
        }
      }
    }.launchIn(viewModelScope)
  }

  fun openURLInBrowser(uri: String?) {
    var url = uri ?: "https://rocketlaunches.app"

    if (!url.startsWith("http://") && !url.startsWith("https://")) {
      url = "http://$url"
    }

    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    mContext.startActivity(browserIntent)
  }
}