package com.asacoding.dolphin_architecture.data.remote.apiService

import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRs
import retrofit2.http.Body
import retrofit2.http.POST

interface ReportingApi {
    @POST("getDailyReport")
    suspend fun getDailyReport(@Body reportDtoRq: ReportDtoRq): ReportDtoRs

    @POST("getBillerReport")
    suspend fun getBillerReport(@Body reportDtoRq: ReportDtoRq): ReportDtoRs

    @POST("getTrx")
    suspend fun getTransaction(@Body reportDtoRq: ReportDtoRq): ReportDtoRs

}