package com.asacoding.dolphin_architecture.domain.repository.remote

import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRs


interface AuthRepository {
    suspend fun doLogin(loginDtoRq: LoginDtoRq): LoginDtoRs
}