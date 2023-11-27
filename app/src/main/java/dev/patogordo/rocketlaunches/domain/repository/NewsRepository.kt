package dev.patogordo.rocketlaunches.domain.repository

import dev.patogordo.rocketlaunches.data.remote.dto.news_article.NewsArticleDto

interface NewsRepository {
  suspend fun listRecentNews(): List<NewsArticleDto>
}