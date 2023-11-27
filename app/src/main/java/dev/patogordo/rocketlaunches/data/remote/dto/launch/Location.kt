package dev.patogordo.rocketlaunches.data.remote.dto.launch

import com.google.gson.annotations.SerializedName

data class Location(
    val country: String?,
    val id: Int?,
    val name: String?,
    val slug: String?,
    val state: String?,
    @SerializedName("statename")
    val stateName: String?
)