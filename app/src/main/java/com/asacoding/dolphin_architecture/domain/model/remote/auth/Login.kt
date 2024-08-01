package com.asacoding.dolphin_architecture.domain.model.remote.auth

data class Login(
    /*val runnerName: String? = null,*/
    val status: Status? = Status( msg = "", code = ""),
    val firstLogin :Int= 0,
) {
    data class Status(
        val code: String = "",
        val msg: String? = null
    )
}

fun Login.isDataValid(): Boolean {
    return !(/*runnerName.isNullOrEmpty() &&*/ status?.code.isNullOrEmpty() && status?.msg.isNullOrEmpty())
}







