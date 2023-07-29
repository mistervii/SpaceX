package com.msp.spacex.data.model.Launches


data class SecondStage(
    val block: Int?,
    val payloads: List<Payload>
)