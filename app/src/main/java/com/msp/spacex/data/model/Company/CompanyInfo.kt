package com.msp.spacex.data.model.Company


import com.google.gson.annotations.SerializedName

data class CompanyInfo(
    val ceo: String,
    val coo: String,
    val cto: String,
    @SerializedName("cto_propulsion")
    val ctoPropulsion: String,
    val employees: Int,
    val founded: Int,
    val founder: String,
    val headquarters: Headquarters,
    @SerializedName("launch_sites")
    val launchSites: Int,
    val name: String,
    val summary: String,
    @SerializedName("test_sites")
    val testSites: Int,
    val valuation: Long,
    val vehicles: Int
)