package com.asacoding.dolphin_architecture.data.repository

import com.asacoding.dolphin_architecture.data.remote.apiService.ReportingApi
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRs
import com.asacoding.dolphin_architecture.domain.repository.remote.ReportingRepository

import javax.inject.Inject

class ReportingRepositoryImpl @Inject constructor(
    private val api: ReportingApi
) : ReportingRepository {
    override suspend fun getDailyReport(reportDtoRq: ReportDtoRq): ReportDtoRs {
        return api.getDailyReport(reportDtoRq)
    }

    override suspend fun getBillerReport(reportDtoRq: ReportDtoRq): ReportDtoRs {
        return api.getBillerReport(reportDtoRq)
    }

    override suspend fun getTransaction(reportDtoRq: ReportDtoRq): ReportDtoRs {
        return api.getTransaction(reportDtoRq)
    }

}