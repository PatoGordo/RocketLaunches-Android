package dev.patogordo.rocketlaunches.domain.repository

import dev.patogordo.rocketlaunches.data.remote.dto.launch.LaunchDto

interface LaunchRepository {
  suspend fun listIncomingLaunches(): List<LaunchDto>
}