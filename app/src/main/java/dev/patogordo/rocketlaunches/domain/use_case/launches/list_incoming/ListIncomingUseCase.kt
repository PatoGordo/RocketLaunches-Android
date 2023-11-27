package dev.patogordo.rocketlaunches.domain.use_case.launches.list_incoming

import dev.patogordo.rocketlaunches.common.Resource
import dev.patogordo.rocketlaunches.data.remote.dto.launch.toLaunch
import dev.patogordo.rocketlaunches.domain.model.Launch
import dev.patogordo.rocketlaunches.domain.repository.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListIncomingUseCase @Inject constructor(
  private val repository: LaunchRepository
) {
  operator fun invoke(): Flow<Resource<List<Launch>>> = flow {
    try {
      emit(Resource.Loading())

      val result = repository.listIncomingLaunches().map {
        it.toLaunch()
      }

      emit(Resource.Success(result))
    } catch (e: HttpException) {
      emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
    } catch (e: IOException) {
      emit(Resource.Error("Couldn't reach server. Please check your internet connection"))
    }
  }
}