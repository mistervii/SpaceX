package com.msp.spacex.data.api

import com.msp.spacex.data.model.Company.CompanyInfo
import com.msp.spacex.data.model.Launches.LaunchesItem
import retrofit2.Response
import retrofit2.http.GET

interface LaunchesApi {
    @GET("launches")
    suspend fun getLaunches(): Response<List<LaunchesItem>>
}