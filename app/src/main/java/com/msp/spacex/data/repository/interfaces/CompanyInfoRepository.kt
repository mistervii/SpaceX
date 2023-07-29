package com.msp.spacex.data.repository.interfaces

import com.msp.spacex.data.model.Company.CompanyInfo
import com.msp.spacex.utils.Results
import kotlinx.coroutines.flow.Flow

interface CompanyInfoRepository {
    fun getCompanyInfo() : Flow<Results<CompanyInfo>>
}