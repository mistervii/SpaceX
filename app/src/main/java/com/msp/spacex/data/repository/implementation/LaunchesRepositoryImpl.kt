package com.msp.spacex.data.repository.implementation

import com.msp.spacex.data.RetrofitApi
import com.msp.spacex.data.api.LaunchesApi
import com.msp.spacex.data.model.Launches.Launches
import com.msp.spacex.data.model.Launches.LaunchesItem
import com.msp.spacex.data.repository.interfaces.LaunchesRepository
import com.msp.spacex.utils.Results
import com.msp.spacex.utils.handleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LaunchesRepositoryImpl :LaunchesRepository {
    override fun getAllLaunches(): Flow<Results<List<LaunchesItem>>> = flow {
        emit(Results.Loading)
        try {
            emit(
                RetrofitApi.newInstance().create(LaunchesApi::class.java)
                    .getLaunches()
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