package dev.patogordo.rocketlaunches.presentation.screen.launches_screen._preview

import dev.patogordo.rocketlaunches.data.remote.dto.launch.Location
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Mission
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Pad
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Provider
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Tag
import dev.patogordo.rocketlaunches.data.remote.dto.launch.Vehicle
import dev.patogordo.rocketlaunches.domain.model.Launch

val previewLaunchData = Launch(
  id = 1,
  name = "Testing Mission",
  slug = "testing_mission",
  vehicle = Vehicle(
    id = 1,
    slug = "falcon_nine",
    name = "Falcon 9",
    companyId = 1
  ),
  tags = listOf(
    Tag(
      id = 1,
      text = "SpaceX"
    )
  ),
  t0 = "2023-11-28T04:00Z",
  date = "1701144000",
  suborbital = false,
  result =  -1,
  provider = Provider(
    id = 1,
    name = "SpaceX",
    slug = "spacex",
  ),
  pad = Pad(
    id = 1,
    name = "SLC-40",
    location = Location(
      id = 62,
      name = "Cape Canaveral SFS",
      state = "FL",
      stateName = "Florida",
      country =  "United States",
      slug =  "cape-canaveral-sfs"
    )
  ),
  missions = listOf(
    Mission(
      id = 5861,
      name = "Starlink-124 (6-30)",
      description = "Testing mission"
    )
  ),
  launchDescription = "A SpaceX Falcon 9 rocket will launch the Starlink-124 (6-30) mission on Tuesday, November 28, 2023 at 4:00 AM (UTC).",
  missionDescription = "",
)