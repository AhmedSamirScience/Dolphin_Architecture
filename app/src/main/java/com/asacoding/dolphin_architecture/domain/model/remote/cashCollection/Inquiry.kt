package com.asacoding.dolphin_architecture.domain.model.remote.cashCollection

data class Inquiry(
    val fees: String? = null,
    val totalAmount: String? = null,
    val billRefInfo: String? = null,
    val billingAccount: String? = null,
    val status: Status? = null,
    val ePayBillReqID: String?=null,
) {
    data class Status(
        val code: String? = null,
        val msg: String? = null
    )
}

fun Inquiry.isDataValid(): Boolean {
    return !(fees.isNullOrEmpty() && totalAmount.isNullOrEmpty() && billRefInfo.isNullOrEmpty() && billingAccount.isNullOrEmpty() && status?.code.isNullOrEmpty() && status?.msg.isNullOrEmpty() && ePayBillReqID.isNullOrEmpty())
}

