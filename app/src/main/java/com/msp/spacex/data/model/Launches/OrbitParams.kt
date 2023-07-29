package com.msp.spacex.data.model.Launches


import com.google.gson.annotations.SerializedName

data class OrbitParams(
    @SerializedName("apoapsis_km")
    val apoapsisKm: Double?,
    @SerializedName("arg_of_pericenter")
    val argOfPericenter: Double?,
    val eccentricity: Double?,
    val epoch: String?,
    @SerializedName("inclination_deg")
    val inclinationDeg: Double?,
    @SerializedName("lifespan_years")
    val lifespanYears: Double?,
    val longitude: Double?,
    @SerializedName("mean_anomaly")
    val meanAnomaly: Double?,
    @SerializedName("mean_motion")
    val meanMotion: Double?,
    @SerializedName("periapsis_km")
    val periapsisKm: Double?,
    @SerializedName("period_min")
    val periodMin: Double?,
    val raan: Double?,
    @SerializedName("reference_system")
    val referenceSystem: String?,
    val regime: String?,
    @SerializedName("semi_major_axis_km")
    val semiMajorAxisKm: Double?
)