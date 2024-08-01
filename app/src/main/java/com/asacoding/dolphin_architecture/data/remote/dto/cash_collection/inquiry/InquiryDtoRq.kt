package com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.inquiry

import com.google.gson.annotations.SerializedName

data class InquiryDtoRq(

    @SerializedName("senderId")
    val senderID: String,
    @SerializedName("billingAccount")
    val billingAccount: String,
    @SerializedName("reservationDate")
    val reservationDate: String,
    @SerializedName("reservationItem")
    val reservationItem: String,
    @SerializedName("billerId")
    val billerID: String,
    @SerializedName("numberOfTickets")
    val numberOfTickets: String,
    @SerializedName("posSn")
    val posSn: String,
)