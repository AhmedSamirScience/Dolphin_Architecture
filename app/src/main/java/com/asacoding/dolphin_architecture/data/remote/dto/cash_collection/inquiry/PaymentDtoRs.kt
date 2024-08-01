package com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry

import com.google.gson.annotations.SerializedName

data class PaymentDtoRs(
    @SerializedName("status")
    val status: Status? = null,
    @SerializedName("paidAmount")
    val amount: String,
    @SerializedName("billerId")
    val billerID: String,
    @SerializedName("billingAccount")
    val billingAccount: String,
    @SerializedName("clientDate")
    val clientDate: String,
    @SerializedName("qrCode")
    val qrCode: String,
    @SerializedName("transactionNo")
    val transactionNo: String,
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