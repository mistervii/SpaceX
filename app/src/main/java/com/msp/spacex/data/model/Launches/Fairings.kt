package com.msp.spacex.data.model.Launches


import com.google.gson.annotations.SerializedName

data class Fairings(
    val recovered: Boolean?,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Boolean?,
    val reused: Boolean,
    val ship: String?
)