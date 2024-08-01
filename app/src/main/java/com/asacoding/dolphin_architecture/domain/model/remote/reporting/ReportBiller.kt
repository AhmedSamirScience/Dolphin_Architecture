package com.asacoding.dolphin_architecture.domain.model.remote.reporting

data class ReportBiller(
    val status: Status? = null,
    val posSerialNumber: String? = null,
    val numOfTransactions: Int? = null,
    val totalAmount: Double? = null,

    ) {
    data class Status(
        val code: Int? = null,
        val msg: String? = null
    )
}

fun ReportBiller.isDataValid(): Boolean {
    return status != null && numOfTransactions != null && totalAmount != null
}