package com.asacoding.dolphin_architecture.domain.repository.remote

import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRs


interface ReportingRepository {
    suspend fun getDailyReport(reportDtoRq: ReportDtoRq): ReportDtoRs
    suspend fun getBillerReport(reportDtoRq: ReportDtoRq): ReportDtoRs
    suspend fun getTransaction(reportDtoRq: ReportDtoRq): ReportDtoRs
}