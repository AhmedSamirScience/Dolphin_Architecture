package com.asacoding.dolphin_architecture.domain.mapper.auth.login


import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRs
import com.asacoding.dolphin_architecture.domain.model.remote.auth.Login

class LoginRsMapper {
    fun buildFrom(loginDtoRs: LoginDtoRs, flag: Int): Login {
        return Login(
            status = Login.Status(code = "loginDtoRs.status?.code", msg = ""),
            firstLogin = flag
        )
    }
}

