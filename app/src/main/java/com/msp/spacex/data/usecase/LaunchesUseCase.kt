package com.msp.spacex.data.usecase

import com.msp.spacex.data.model.Launches.LaunchesItem
import com.msp.spacex.data.repository.interfaces.LaunchesRepository
import com.msp.spacex.utils.Results
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchesUseCase @Inject constructor(
    val launchesRepository: LaunchesRepository
) {
    fun getAllLaunches() : Flow<Results<List<LaunchesItem>>> = launchesRepository.getAllLaunches()
}