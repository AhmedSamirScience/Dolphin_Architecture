package com.asacoding.dolphin_architecture.domain.use_case.auth.login.dataSource

 import com.asacoding.dolphin_architecture.common.constants.LocalKeys
 import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
 import com.asacoding.dolphin_architecture.domain.model.remote.auth.Login
import com.asacoding.dolphin_architecture.domain.model.remote.auth.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.dataSource.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CheckFirstLoginUseCase @Inject constructor(
    private val repositoryLocal: LocalRepository
) {
    operator fun invoke(): Flow<RequestResource<Login>> = flow {
        try {
            /**
             * why we are using login (from Domain) and not Login Rs because we need to isDataValid function to validate if the sharedPreference Data is empty or not
             */
            val login = repositoryLocal.returnLogin(LocalKeys.LOGIN_RS)
            if (!login.isDataValid())
                emit(RequestResource.ErrorResponse(message = "body is null or blank."))
            else
                emit(RequestResource.Success(login))
        } catch (e: HttpException) {
            emit(RequestResource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(RequestResource.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}