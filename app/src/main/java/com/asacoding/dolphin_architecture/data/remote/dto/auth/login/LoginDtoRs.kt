package com.asacoding.dolphin_architecture.data.remote.dto.auth.login

import com.google.gson.annotations.SerializedName

data class LoginDtoRs(
    @SerializedName("status")
    val status: Status? = null
) {
    data class Status(
        @SerializedName("statusCode")
        val code: String? = null,

        @SerializedName("description")
        val msg: String? = null
    )
}