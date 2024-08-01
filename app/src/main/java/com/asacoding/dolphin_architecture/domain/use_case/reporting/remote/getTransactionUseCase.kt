package com.asacoding.dolphin_architecture.domain.use_case.reporting.remote

import android.util.Log
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRq


import com.asacoding.dolphin_architecture.domain.mapper.reporting.DetailedReportRsMapper
import com.asacoding.dolphin_architecture.domain.model.remote.reporting.DetailedReport

import com.asacoding.dolphin_architecture.domain.model.remote.reporting.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.remote.ReportingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTransactionUseCase @Inject constructor(
    private val repository: ReportingRepository
) {
    operator fun invoke(reportDtoRq: ReportDtoRq): Flow<RequestResource<DetailedReport>> = flow {
        try {

            val getTrxReport = DetailedReportRsMapper().buildFrom(
                reportDtoRs = repository.getTransaction(reportDtoRq)
            )

            if (!getTrxReport.isDataValid()) {
                Log.e("GetTransactionUseCase", "   invoke " + getTrxReport)
                emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
            } else if (getTrxReport.numOfTransactions == 0 && getTrxReport.status?.code == 200) {
                emit(RequestResource.ErrorResponse(message = "لا توجد حركات"))
                Log.e("GetTransactionUseCase", "  invoke  " + getTrxReport)

            } else if (getTrxReport.status?.code != 200) {
                Log.e("GetTransactionUseCase", " invoke   " + getTrxReport)
                emit(RequestResource.ErrorResponse(message = getTrxReport.status?.msg.toString()))
            } else {
                Log.e("GetTransactionUseCase", "  invoke  " + getTrxReport)
                emit(RequestResource.Success(getTrxReport))
            }
        } catch (e: HttpException) {
            Log.e("GetTransactionUseCase", " invoke HttpException  ")
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            Log.e("GetTransactionUseCase", "  invoke  IOException")
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}