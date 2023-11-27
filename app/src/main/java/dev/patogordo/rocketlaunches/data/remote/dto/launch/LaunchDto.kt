package dev.patogordo.rocketlaunches.data.remote.dto.launch

import com.google.gson.annotations.SerializedName
import dev.patogordo.rocketlaunches.domain.model.Launch

data class LaunchDto(
  @SerializedName("cospar_id")
  val cosparId: String?,
  @SerializedName("date_str")
  val dateStr: String?,
  @SerializedName("est_date")
  val estDate: EstDate?,
  val id: Int?,
  @SerializedName("launch_description")
  val launchDescription: String?,
  val media: List<Any>?,
  @SerializedName("mission_description")
  val missionDescription: String?,
  val missions: List<Mission>?,
  val modified: String?,
  val name: String?,
  val pad: Pad?,
  val provider: Provider?,
  @SerializedName("quicktext")
  val quickText: String?,
  val result: Int?,
  val slug: String?,
  @SerializedName("sort_date")
  val sortDate: String?,
  val suborbital: Boolean?,
  val t0: String?,
  val tags: List<Tag>?,
  val vehicle: Vehicle?,
  @SerializedName("weather_condition")
  val weatherCondition: Any?,
  @SerializedName("weather_icon")
  val weatherIcon: Any?,
  @SerializedName("weather_summary")
  val weatherSummary: Any?,
  @SerializedName("weather_temp")
  val weatherTemp: Any?,
  @SerializedName("weather_updated")
  val weatherUpdated: Any?,
  @SerializedName("weather_wind_mph")
  val weatherWindMph: Any?,
  @SerializedName("win_close")
  val winClose: Any?,
  @SerializedName("win_open")
  val winOpen: Any?
)

fun LaunchDto.toLaunch() : Launch {
  return Launch(
    id = id,
    launchDescription = launchDescription,
    date = sortDate,
    missionDescription = missionDescription,
    missions = missions,
    name = name,
    pad = pad,
    provider = provider,
    result = result,
    slug = slug,
    suborbital = suborbital,
    t0 = t0,
    tags = tags,
    vehicle = vehicle
  )
}