package com.msp.spacex.data.model.Launches


import com.google.gson.annotations.SerializedName

data class Telemetry(
    @SerializedName("flight_club")
    val flightClub: String?
)