package com.asacoding.dolphin_architecture.data.dataSource.repository

import com.asacoding.dolphin_architecture.data.dataSource.base.PreferencesManager
import com.asacoding.dolphin_architecture.domain.model.remote.auth.Login
import com.asacoding.dolphin_architecture.domain.repository.dataSource.LocalRepository

import javax.inject.Inject

class LocalRepositoryImplementation @Inject constructor(
    private val prefManager: PreferencesManager
): LocalRepository
{
    //region Login Response
    override suspend fun saveLogin(key: String, bodyRs: Login) {
        prefManager.saveObject(key,bodyRs )
    }
    override suspend fun returnLogin(key: String): Login {
        return prefManager.getObject(key , Login::class.java)
    }
    //endregion
}