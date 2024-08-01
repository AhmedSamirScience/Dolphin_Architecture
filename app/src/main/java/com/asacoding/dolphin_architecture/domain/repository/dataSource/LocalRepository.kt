package com.asacoding.dolphin_architecture.domain.repository.dataSource

import com.asacoding.dolphin_architecture.domain.model.remote.auth.Login

interface LocalRepository {
    //region Login Response
    suspend fun saveLogin(key: String, bodyRs: Login)
    suspend fun returnLogin(key: String): Login
    //endregion
}