package dev.patogordo.rocketlaunches.presentation.screen.home_screen.states

import dev.patogordo.rocketlaunches.domain.model.NewsArticle

data class NewsListState (
  val isLoading: Boolean = false,
  val error: String = "",
  val news: List<NewsArticle> = emptyList(),
)
