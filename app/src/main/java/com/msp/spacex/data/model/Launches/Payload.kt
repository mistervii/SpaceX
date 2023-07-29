package com.msp.spacex.data.model.Launches


import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("cap_serial")
    val capSerial: String?,
    @SerializedName("cargo_manifest")
    val cargoManifest: String?,
    val customers: List<String>,
    @SerializedName("flight_time_sec")
    val flightTimeSec: Int?,
    val manufacturer: String?,
    @SerializedName("mass_returned_kg")
    val massReturnedKg: Double?,
    @SerializedName("mass_returned_lbs")
    val massReturnedLbs: Double?,
    val nationality: String?,
    @SerializedName("norad_id")
    val noradId: List<Int>,
    val orbit: String,
    @SerializedName("orbit_params")
    val orbitParams: OrbitParams,
    @SerializedName("payload_id")
    val payloadId: String,
    @SerializedName("payload_mass_kg")
    val payloadMassKg: Double?,
    @SerializedName("payload_mass_lbs")
    val payloadMassLbs: Double?,
    @SerializedName("payload_type")
    val payloadType: String,
    val reused: Boolean
)