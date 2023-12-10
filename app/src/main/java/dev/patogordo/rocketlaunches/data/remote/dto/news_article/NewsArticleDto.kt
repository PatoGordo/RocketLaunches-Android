package dev.patogordo.rocketlaunches.data.remote.dto.news_article

import dev.patogordo.rocketlaunches.domain.model.NewsArticle

data class NewsArticleDto(
  val events: List<Any>?,
  val featured: Boolean?,
  val id: Int?,
  val imageUrl: String?,
  val launches: List<Launche>?,
  val newsSite: String?,
  val publishedAt: String?,
  val summary: String?,
  val title: String?,
  val updatedAt: String?,
  val url: String?,
)

fun NewsArticleDto.toNewsArticle() : NewsArticle {
  return NewsArticle(
    id = id,
    events = events,
    newsSite = newsSite,
    imageUrl = imageUrl,
    launches = launches,
    publishedAt = publishedAt,
    summary = summary,
    title = title,
    url = url
  )
}

