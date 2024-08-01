package com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry

import com.google.gson.annotations.SerializedName

data class InquiryDtoRs(
    @SerializedName("status")
    val status: Status? = null,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("fees")
    val fees: String,
    @SerializedName("service_name")
    val serviceName: String,
    @SerializedName("totalAmount")
    val totalAmount: String,
    @SerializedName("billRefInfo")
    val billRefInfo: String,
    @SerializedName("billingAccount")
    val billingAccount: String,
    @SerializedName("ticket")
    val ticket: String,
    @SerializedName("EpaybillreqID")
    val ePayBillReqID: String,
) {
    data class Status(
        @SerializedName("statusCode")
        val code: String? = null,

        @SerializedName("description")
        val msg: String? = null
    )
}