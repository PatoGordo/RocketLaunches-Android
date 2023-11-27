package dev.patogordo.rocketlaunches.presentation.screen.news_screen.states

import dev.patogordo.rocketlaunches.domain.model.NewsArticle

data class NewsListState(
  val isLoading: Boolean = false,
  val newsArticles: List<NewsArticle> = emptyList(),
  val error: String = ""
)
