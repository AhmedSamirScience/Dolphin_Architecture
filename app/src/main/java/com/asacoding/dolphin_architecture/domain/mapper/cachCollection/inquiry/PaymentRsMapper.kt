package com.asacoding.dolphin_architecture.domain.mapper.cachCollection.inquiry


import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry.PaymentDtoRs
import idhcorp.mokhtabar.chemist.domain.model.remote.cashCollection.Payment


class PaymentRsMapper {
    fun buildFrom(paymentDtoRs: PaymentDtoRs): Payment {
        return Payment(
            billingAccount = paymentDtoRs.billingAccount,
            amount = paymentDtoRs.amount,
            transactionNo = paymentDtoRs.transactionNo,
            status = Payment.Status(
                code = paymentDtoRs.status?.code,
                msg = paymentDtoRs.status?.msg
            ),
            billerID = paymentDtoRs.billerID,
            clientDate = paymentDtoRs.clientDate,
            ePayBillReqID = paymentDtoRs.ePayBillReqID
        )
    }
}