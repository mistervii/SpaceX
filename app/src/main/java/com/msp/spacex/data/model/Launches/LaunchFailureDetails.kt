package com.msp.spacex.data.model.Launches


import com.google.gson.annotations.SerializedName

data class LaunchFailureDetails(
    val altitude: Int?,
    val reason: String,
    val time: Int
)