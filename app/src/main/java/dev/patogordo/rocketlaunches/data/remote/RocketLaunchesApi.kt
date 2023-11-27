package dev.patogordo.rocketlaunches.data.remote

import dev.patogordo.rocketlaunches.data.remote.dto.ResultOf
import dev.patogordo.rocketlaunches.data.remote.dto.launch.LaunchDto
import dev.patogordo.rocketlaunches.data.remote.dto.news_article.NewsArticleDto
import retrofit2.http.GET

interface RocketLaunchesApi {
  @GET("launches")
  suspend fun listIncomingLaunches() : ResultOf<List<LaunchDto>>
  @GET("/news")
  suspend fun listRecentNews() : ResultOf<List<NewsArticleDto>>

//  @GET("/launches/{launchId}")
//  suspend fun getLaunchById(@Path("launchId") launchId: String): LaunchDetailsDto
}
