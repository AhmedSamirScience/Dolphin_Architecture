package com.asacoding.dolphin_architecture.domain.use_case.reporting.remote

import android.util.Log
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRq


import com.asacoding.dolphin_architecture.domain.mapper.reporting.ReportBillerRsMapper
import com.asacoding.dolphin_architecture.domain.model.remote.reporting.ReportBiller

import com.asacoding.dolphin_architecture.domain.model.remote.reporting.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.remote.ReportingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBillerReportUseCase @Inject constructor(
    private val repository: ReportingRepository,

    ) {
    operator fun invoke(reportDtoRq: ReportDtoRq): Flow<RequestResource<ReportBiller>> = flow {
        try {

            val getBillerReport =
                ReportBillerRsMapper().buildFrom(reportDtoRs = repository.getBillerReport(reportDtoRq))

            if (!getBillerReport.isDataValid()) {
                Log.e("GetBillerReportUseCase", "  invoke  $getBillerReport")
                emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
            } else if (getBillerReport.numOfTransactions == 0 && getBillerReport.status?.code == 200) {
                emit(RequestResource.ErrorResponse(message = "لا توجد حركات"))
                Log.e("GetBillerReportUseCase", "  invoke  $getBillerReport")
            } else if (getBillerReport.status?.code != 200) {
                Log.e("GetBillerReportUseCase", "  invoke  " + getBillerReport)
                emit(RequestResource.ErrorResponse(message = getBillerReport.status?.msg.toString()))
            } else {
                Log.e("GetBillerReportUseCase", "   invoke " + getBillerReport)
                emit(RequestResource.Success(getBillerReport))
            }
        } catch (e: HttpException) {
            Log.e("GetBillerReportUseCase", "   invoke HttpException")
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            Log.e("GetBillerReportUseCase", "  invoke  IOException")
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}