package com.asacoding.dolphin_architecture.domain.use_case.cashCollection.remote

import android.util.Log
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRq


import com.asacoding.dolphin_architecture.domain.mapper.cachCollection.inquiry.PaymentRsMapper
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.Payment

import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.remote.CashCollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DoPaymentUseCase @Inject constructor(
    private val repository: CashCollectionRepository
) {
    operator fun invoke(paymentDtoRq: PaymentDtoRq): Flow<RequestResource<Payment>> = flow {
        try {
            val response = repository.doPayment(paymentDtoRq)
            Log.e("aaaaaaaa", "DoPaymentUseCase  =  " + response)

            val doPayment = PaymentRsMapper().buildFrom(paymentDtoRs = response)
            if (!doPayment.isDataValid()) {
                emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
            } else if (doPayment.status?.code == "200") {
                emit(RequestResource.Success(doPayment))
            } else {
                emit(RequestResource.ErrorResponse(doPayment.status?.msg.toString()))
            }
        } catch (e: HttpException) {
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}