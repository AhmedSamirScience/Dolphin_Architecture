package com.asacoding.dolphin_architecture.domain.mapper.cachCollection.inquiry


import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.InquiryDtoRs
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.Inquiry


class InquiryRsMapper {
    fun buildFrom(response: InquiryDtoRs): Inquiry {
        return Inquiry(
            billingAccount = response.billingAccount,
            billRefInfo = response.billRefInfo,
            ePayBillReqID = response.ePayBillReqID,
            fees = response.fees,
            totalAmount = response.totalAmount,
            status = Inquiry.Status(code = response.status?.code, msg = response.status?.msg)
        )
    }
}

