package com.asacoding.dolphin_architecture.data.repository

import com.asacoding.dolphin_architecture.data.remote.apiService.AuthApi
import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRs
import com.asacoding.dolphin_architecture.domain.repository.remote.AuthRepository

import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {

    //region Login Fragment
    override suspend fun doLogin(loginDtoRq: LoginDtoRq): LoginDtoRs {
        return api.doLogin(loginDtoRq)
    }
    //endregion
}