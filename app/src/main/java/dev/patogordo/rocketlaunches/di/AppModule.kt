package dev.patogordo.rocketlaunches.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.patogordo.rocketlaunches.common.Constants
import dev.patogordo.rocketlaunches.data.remote.RocketLaunchesApi
import dev.patogordo.rocketlaunches.data.repository.LaunchRepositoryImpl
import dev.patogordo.rocketlaunches.data.repository.NewsRepositoryImpl
import dev.patogordo.rocketlaunches.domain.repository.LaunchRepository
import dev.patogordo.rocketlaunches.domain.repository.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Provides
  @Singleton
  fun provideRocketLaunchesApi() : RocketLaunchesApi {
    return Retrofit.Builder()
      .baseUrl(Constants.ROCKET_LAUNCHES_BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(RocketLaunchesApi::class.java)
  }

  @Provides
  @Singleton
  fun provideLaunchRepository(api: RocketLaunchesApi): LaunchRepository {
    return LaunchRepositoryImpl(api)
  }

  @Provides
  @Singleton
  fun provideNewsRepository(api: RocketLaunchesApi): NewsRepository {
    return NewsRepositoryImpl(api)
  }
}