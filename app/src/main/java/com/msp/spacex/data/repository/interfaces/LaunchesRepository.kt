package com.msp.spacex.data.repository.interfaces

import com.msp.spacex.data.model.Launches.Launches
import com.msp.spacex.data.model.Launches.LaunchesItem
import com.msp.spacex.utils.Results
import kotlinx.coroutines.flow.Flow

interface LaunchesRepository {
    fun getAllLaunches() : Flow<Results<List<LaunchesItem>>>
}