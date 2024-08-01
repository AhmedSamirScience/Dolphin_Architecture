package com.asacoding.dolphin_architecture.data.repository

import com.asacoding.dolphin_architecture.data.remote.apiService.CashCollectionApi
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicSchedulesDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRs
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRs
import com.asacoding.dolphin_architecture.domain.repository.remote.CashCollectionRepository

import javax.inject.Inject

class CashCollectionRepositoryImpl @Inject constructor(
    private val api: CashCollectionApi
) : CashCollectionRepository {

    //region cash collection fragment
    override suspend fun getClinics(): List<ClinicDtoRs> {
        return api.getClinics()
    }

    override suspend fun getClinicSchedules(clinicID: Int): ClinicSchedulesDtoRs {
        return api.getClinicSchedules(clinicID)
    }
    //endregion


    // region cash collection fragment
    override suspend fun doInquiry(inquiryDtoRq: InquiryDtoRq): InquiryDtoRs {
        return api.doInquiry(inquiryDtoRq)
    }

    override suspend fun doPayment(paymentDtoRq: PaymentDtoRq): PaymentDtoRs {
        return api.doPayment(paymentDtoRq)
    }
    //endregion

}