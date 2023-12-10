package dev.patogordo.rocketlaunches.domain.model

import dev.patogordo.rocketlaunches.data.remote.dto.news_article.Launche

data class NewsArticle(
  val events: List<Any>?,
  val id: Int?,
  val imageUrl: String?,
  val launches: List<Launche>?,
  val newsSite: String?,
  val publishedAt: String?,
  val summary: String?,
  val title: String?,
  val url: String?,
)
