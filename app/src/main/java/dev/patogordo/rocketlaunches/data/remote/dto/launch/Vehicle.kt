package dev.patogordo.rocketlaunches.data.remote.dto.launch

import com.google.gson.annotations.SerializedName

data class Vehicle(
    @SerializedName("company_id")
    val companyId: Int?,
    val id: Int?,
    val name: String?,
    val slug: String?
)