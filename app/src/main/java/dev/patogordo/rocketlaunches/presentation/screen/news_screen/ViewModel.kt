package dev.patogordo.rocketlaunches.presentation.screen.news_screen

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
import dev.patogordo.rocketlaunches.domain.use_case.news.list_recent.ListRecentUseCase
import dev.patogordo.rocketlaunches.presentation.screen.news_screen.states.NewsListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class NewsViewModel @Inject constructor(
  private val listRecentUseCase: ListRecentUseCase,
  @ApplicationContext private val mContext: Context,
): ViewModel() {
  private val _state = mutableStateOf(NewsListState())
  val state: State<NewsListState> = _state

  init {
    getRecentNews()
  }

  private fun getRecentNews() {
    listRecentUseCase().onEach { result ->
      when (result) {
        is Resource.Success -> {
          _state.value = NewsListState(
            news = result.data ?: emptyList()
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