package com.msp.spacex.data.model.Company


import com.google.gson.annotations.SerializedName

data class Headquarters(
    val address: String,
    val city: String,
    val state: String
)