package com.msp.spacex.data.repository.implementation

import com.msp.spacex.data.RetrofitApi
import com.msp.spacex.data.api.CompanyInfoApi
import com.msp.spacex.data.api.LaunchesApi
import com.msp.spacex.data.model.Company.CompanyInfo
import com.msp.spacex.data.repository.interfaces.CompanyInfoRepository
import com.msp.spacex.utils.Results
import com.msp.spacex.utils.handleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CompanyInfoRepositriyImpl : CompanyInfoRepository{
    override fun getCompanyInfo(): Flow<Results<CompanyInfo>> = flow {
        emit(Results.Loading)
        try {
            emit(
                RetrofitApi.newInstance().create(CompanyInfoApi::class.java)
                    .getCompanyInfo()
                    .handleResponse(
                        onError = {
                            Results.Error(Exception(it))
                        },
                        onSuccess = {
                            Results.Success(it!!)
                        }
                    )
            )
        } catch (e: Exception) {
            emit(Results.Error(e))
        }
    }.flowOn(Dispatchers.IO)
}