package com.msp.spacex.data.api

import com.msp.spacex.data.model.Company.CompanyInfo
import retrofit2.Response
import retrofit2.http.GET

interface CompanyInfoApi {
    @GET("info")
    suspend fun getCompanyInfo(): Response<CompanyInfo>
}