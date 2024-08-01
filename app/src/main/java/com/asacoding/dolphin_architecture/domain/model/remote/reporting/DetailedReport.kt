package com.asacoding.dolphin_architecture.domain.model.remote.reporting

data class DetailedReport(
    val status: Status? = null,
    val numOfTransactions: Int? = null,
    val totalAmount: Double? = null,
    val paymentList: List<Payment>? = null

) {
    data class Status(
        val code: Int? = null,
        val msg: String? = null
    )

    data class Payment(
        val paymentID: String? = null,
        val billingAccount: String? = null,
        val clinicName: String? = null,
        val amount: Double? = null,
    )

}

fun DetailedReport.isDataValid(): Boolean {
    return status != null && numOfTransactions != null && totalAmount != null && !paymentList.isNullOrEmpty() && paymentList.fold(
        true,
        operation = { prev, value -> prev && value.isDataValid() })
}

fun DetailedReport.Payment.isDataValid(): Boolean {
    return !paymentID.isNullOrEmpty() && !billingAccount.isNullOrEmpty() && !clinicName.isNullOrEmpty() && amount != null
}