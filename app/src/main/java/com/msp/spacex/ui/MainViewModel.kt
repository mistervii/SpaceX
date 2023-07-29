package com.msp.spacex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.msp.spacex.data.usecase.CompanyInfoUseCase
import com.msp.spacex.data.usecase.LaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject() constructor(
    private val companyInfoUseCase: CompanyInfoUseCase,
    private val launchesUseCase: LaunchesUseCase
) : ViewModel() {

    fun getCompanyInfo() = companyInfoUseCase.getCompanyInfo().asLiveData()
    fun getAllLaunches() = launchesUseCase.getAllLaunches().asLiveData()
}