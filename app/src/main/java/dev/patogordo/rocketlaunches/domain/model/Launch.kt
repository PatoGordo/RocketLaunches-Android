package dev.patogordo.rocketlaunches.domain.model

import dev.patogordo.rocketlaunches.data.remote.dto.launch.EstDate
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Mission
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Pad
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Provider
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Tag
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Vehicle

data class Launch(
  val date: String?,
  val id: Int?,
  val launchDescription: String?,
  val missionDescription: String?,
  val missions: List<Mission>?,
  val name: String?,
  val pad: Pad?,
  val provider: Provider?,
  val result: Int?,
  val slug: String?,
  val suborbital: Boolean?,
  val t0: String?,
  val tags: List<Tag>?,
  val vehicle: Vehicle?,
)
