package com.asacoding.dolphin_architecture.domain.use_case.reporting.remote

import android.util.Log
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRq


import com.asacoding.dolphin_architecture.domain.mapper.reporting.DailyReportRsMapper
import com.asacoding.dolphin_architecture.domain.model.remote.reporting.DailyReport
import com.asacoding.dolphin_architecture.domain.model.remote.reporting.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.remote.ReportingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDailyReportUseCase @Inject constructor(
    private val repository: ReportingRepository
) {
    operator fun invoke(reportDtoRq: ReportDtoRq): Flow<RequestResource<DailyReport>> = flow {
        try {
            val getDailyReport =
                DailyReportRsMapper().buildFrom(reportDtoRs = repository.getDailyReport(reportDtoRq))
            if (!getDailyReport.isDataValid()) {
                Log.e("GetDailyReportUseCase", "invoke isDataValid    " + getDailyReport)
                emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
            } else if (getDailyReport.numOfTransactions == 0 && getDailyReport.status?.code == 200) {
                Log.e("GetDailyReportUseCase", "invoke numOfTransactions")
                emit(RequestResource.ErrorResponse(message = "لا توجد حركات"))
            } else if (getDailyReport.status?.code != 200) {
                Log.e("GetDailyReportUseCase", "invoke status?.code != 200")
                emit(RequestResource.ErrorResponse(message = getDailyReport.status?.msg.toString()))
            } else {
                Log.e("GetDailyReportUseCase", "invoke else")
                emit(RequestResource.Success(getDailyReport))
            }
        } catch (e: HttpException) {
            Log.e("GetDailyReportUseCase", "invoke HttpException")
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            Log.e("GetDailyReportUseCase", "invoke IOException")
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}