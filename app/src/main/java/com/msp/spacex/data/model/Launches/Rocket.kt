package com.msp.spacex.data.model.Launches


import com.google.gson.annotations.SerializedName

data class Rocket(
    val fairings: Fairings?,
    @SerializedName("first_stage")
    val firstStage: FirstStage,
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String,
    @SerializedName("second_stage")
    val secondStage: SecondStage
)