package com.asacoding.dolphin_architecture.domain.model.remote.reporting


data class DailyReport(
    val status: Status? = null,
    val numOfTransactions: Int? = null,
    val totalAmount: Double? = null,

    ) {
    data class Status(
        val code: Int? = null,
        val msg: String? = null
    )


}

fun DailyReport.isDataValid(): Boolean {
    return status != null && numOfTransactions != null && totalAmount != null
}