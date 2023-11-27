package dev.patogordo.rocketlaunches.domain.use_case.news.list_recent

import dev.patogordo.rocketlaunches.common.Resource
import dev.patogordo.rocketlaunches.data.remote.dto.news_article.toNewsArticle
import dev.patogordo.rocketlaunches.domain.model.NewsArticle
import dev.patogordo.rocketlaunches.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListRecentUseCase @Inject constructor(
  private val repository: NewsRepository
) {
  operator fun invoke(): Flow<Resource<List<NewsArticle>>> = flow {
    try {
      emit(Resource.Loading())

      val result = repository.listRecentNews().map {
        it.toNewsArticle()
      }

      emit(Resource.Success(result))
    } catch (e: HttpException) {
      emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
    } catch (e: IOException) {
      emit(Resource.Error("Couldn't reach server. Please check your internet connection"))
    }
  }
}