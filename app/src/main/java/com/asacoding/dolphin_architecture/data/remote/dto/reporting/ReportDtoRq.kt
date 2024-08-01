package com.asacoding.dolphin_architecture.data.remote.dto.reporting

import com.google.gson.annotations.SerializedName

data class ReportDtoRq(

    @SerializedName("reportDate")
    val reportDate: String? = null,

    @SerializedName("posSN")
    val posSerialNumber: String? = null,
)





