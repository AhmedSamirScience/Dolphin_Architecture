package com.asacoding.dolphin_architecture.domain.model.remote.cashCollection

data class Payment(
    val status: Status? = null,
    val amount: String? = null,
    val billingAccount: String? = null,
    val billerID: String? = null,
    val clientDate: String? = null,
    val transactionNo: String? = null,
    val ePayBillReqID: String? = null
) {
    data class Status(
        val code: String? = null,
        val msg: String? = null
    )
}

fun Payment.isDataValid(): Boolean {
    return !(status?.code.isNullOrEmpty() && status?.msg.isNullOrEmpty() && amount.isNullOrEmpty() && billingAccount.isNullOrEmpty() && billerID.isNullOrEmpty() && clientDate.isNullOrEmpty() && transactionNo.isNullOrEmpty())
}

