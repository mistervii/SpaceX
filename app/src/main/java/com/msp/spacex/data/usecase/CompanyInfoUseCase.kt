package com.msp.spacex.data.usecase

import com.msp.spacex.data.model.Company.CompanyInfo
import com.msp.spacex.data.repository.interfaces.CompanyInfoRepository
import com.msp.spacex.utils.Results
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class CompanyInfoUseCase @Inject constructor(
    val companyInfoRepository: CompanyInfoRepository
) {

    fun getCompanyInfo() : Flow<Results<CompanyInfo>> = companyInfoRepository.getCompanyInfo()
}