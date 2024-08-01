package com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry

import com.google.gson.annotations.SerializedName

data class PaymentDtoRq(
    @SerializedName("senderId")
    val senderID: String,
    @SerializedName("billerId")
    val billerID: String,
    @SerializedName("billingAccount")
    val billingAccount: String,
    @SerializedName("clientDate")
    val clientDate: String,
    @SerializedName("pmtId")
    val pmtID: String,
    @SerializedName("billRefInfo")
    val billRefInfo: String,
    @SerializedName("EpaybillreqID")
    val ePayBillReqID: String
)