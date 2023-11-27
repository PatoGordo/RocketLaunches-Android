package dev.patogordo.rocketlaunches.data.repository

import dev.patogordo.rocketlaunches.data.remote.RocketLaunchesApi
import dev.patogordo.rocketlaunches.data.remote.dto.launch.LaunchDto
import dev.patogordo.rocketlaunches.domain.repository.LaunchRepository
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
  private val api: RocketLaunchesApi
) : LaunchRepository {
  override suspend fun listIncomingLaunches(): List<LaunchDto> {
    return api.listIncomingLaunches().result
  }
}
