package com.asacoding.dolphin_architecture.data.remote.dto.reporting

import com.google.gson.annotations.SerializedName

data class ReportDtoRs(
    @SerializedName("status")
    val status: Status? = null,
    @SerializedName("reportDate")
    val reportDate: String? = null,
    @SerializedName("posSerialNumber")
    val posSerialNumber: String? = null,
    @SerializedName("numOfTrx")
    val numOfTransactions: Int? = null,
    @SerializedName("totalAmount")
    val totalAmount: Double? = null,
    @SerializedName("paymentList")
    val paymentList: List<Payment>? = null

) {
    data class Status(
        @SerializedName("statusCode")
        val code: Int? = null,

        @SerializedName("description")
        val msg: String? = null
    )

    data class Payment(
        @SerializedName("pmtid")
        val paymentID: String? = null,
        @SerializedName("billingAccount")
        val billingAccount: String? = null,
        @SerializedName("clinicName")
        val clinicName: String? = null,
        @SerializedName("amount")
        val amount: Double? = null,
    )

}

fun ReportDtoRs.isDataValid(): Boolean {
    return status != null && reportDate != null && posSerialNumber != null && numOfTransactions != null && totalAmount != null
}