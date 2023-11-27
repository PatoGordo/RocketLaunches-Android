package dev.patogordo.rocketlaunches.data.repository

import dev.patogordo.rocketlaunches.data.remote.RocketLaunchesApi
import dev.patogordo.rocketlaunches.data.remote.dto.news_article.NewsArticleDto
import dev.patogordo.rocketlaunches.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
  private val api: RocketLaunchesApi
) : NewsRepository {
  override suspend fun listRecentNews(): List<NewsArticleDto> {
    return api.listRecentNews().result
  }
}
