package com.asacoding.dolphin_architecture.data.remote.apiService

import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicSchedulesDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRs
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface CashCollectionApi {

    //region Cash Collection Fragment
    @GET("clinics")
    suspend fun getClinics(): List<ClinicDtoRs>

    @POST("schedulesDetail")
    suspend fun getClinicSchedules(@Body clinicID: Int): ClinicSchedulesDtoRs
    //endregion

    //region Inquiry Fragment
    @POST("inquiry")
    suspend fun doInquiry(@Body inquiryDtoRq: InquiryDtoRq): InquiryDtoRs

    @POST("payment")
    suspend fun doPayment(@Body paymentDtoRq: PaymentDtoRq): PaymentDtoRs
    //endregion


}