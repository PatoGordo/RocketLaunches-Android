package dev.patogordo.rocketlaunches.presentation.screen.news_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.patogordo.rocketlaunches.common.Resource
import dev.patogordo.rocketlaunches.domain.use_case.news.list_recent.ListRecentUseCase
import dev.patogordo.rocketlaunches.presentation.screen.news_screen.states.NewsListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
  private val listRecentUseCase: ListRecentUseCase
): ViewModel() {
  private val _state = mutableStateOf<NewsListState>(NewsListState())
  val state: State<NewsListState> = _state

  init {
    getRecentNews()
  }

  private fun getRecentNews() {
    listRecentUseCase().onEach { result ->
      when (result) {
        is Resource.Success -> {
          _state.value = NewsListState(
            newsArticles = result.data ?: emptyList()
          )
        }

        is Resource.Error -> {
          _state.value = NewsListState(
            error = result.message ?: "An unexpected error occurred"
          )
        }

        is Resource.Loading -> {
          _state.value = NewsListState(isLoading = true)
        }
      }
    }.launchIn(viewModelScope)
  }
}