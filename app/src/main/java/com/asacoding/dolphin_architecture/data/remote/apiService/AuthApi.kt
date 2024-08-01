package com.asacoding.dolphin_architecture.data.remote.apiService

import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRq
import com.asacoding.dolphin_architecture.data.remote.dto.auth.login.LoginDtoRs
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    //region Login Fragment
    @POST("login")
    suspend fun doLogin(@Body loginDtoRq: LoginDtoRq): LoginDtoRs
    //endregion
}