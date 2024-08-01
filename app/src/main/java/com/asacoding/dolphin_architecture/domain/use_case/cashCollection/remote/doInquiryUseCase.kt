package com.asacoding.dolphin_architecture.domain.use_case.cashCollection.remote

import android.util.Log
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRq


import com.asacoding.dolphin_architecture.domain.mapper.cachCollection.inquiry.InquiryRsMapper
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.Inquiry

import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.remote.CashCollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DoInquiryUseCase @Inject constructor(
    private val repository: CashCollectionRepository
) {
    operator fun invoke(inquiryDtoRq: InquiryDtoRq): Flow<RequestResource<Inquiry>> = flow {
        try {
            val response = repository.doInquiry(inquiryDtoRq)
            Log.e("aaaaaaaa", "DoInquiryUseCase  =  " + response)
            val doInquiry = InquiryRsMapper().buildFrom(response = response)
            if (!doInquiry.isDataValid()) {
                emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
            } else if (doInquiry.status?.code == "200") {
                emit(RequestResource.Success(doInquiry))
            } else {
                emit(RequestResource.ErrorResponse(doInquiry.status?.msg.toString()))
            }
        } catch (e: HttpException) {
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}