package com.asacoding.dolphin_architecture.domain.repository.remote

import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicSchedulesDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRs


interface CashCollectionRepository {
    suspend fun getClinics(): List<ClinicDtoRs>
    suspend fun getClinicSchedules(clinicID: Int): ClinicSchedulesDtoRs
    suspend fun doInquiry(inquiryDtoRq: InquiryDtoRq): InquiryDtoRs
    suspend fun doPayment(paymentDtoRq: PaymentDtoRq): PaymentDtoRs
}