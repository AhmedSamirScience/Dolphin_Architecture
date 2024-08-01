package com.asacoding.dolphin_architecture.domain.use_case.auth.login.remote

import android.util.Log
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource

import com.asacoding.dolphin_architecture.domain.model.remote.auth.Login
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class DoLoginAndSaveResponseUseCase {
    operator fun invoke(): Flow<RequestResource<Login>> = flow  {
        try {
            /**
             * data remote
             */
            /*  val getLogin = loginDtoRq.flag?.let {
                  LoginRsMapper().buildFrom(
                      loginDtoRs = repository.doLogin(loginDtoRq), flag = it
                  )
              }*/


            Log.e("DoLoginAndSaveResponseUseCase" , "before while loop")
            var i = 0
            while (true)
            {

                if(i == 100 )
                    break

                Log.e("DoLoginAndSaveResponseUseCase" , "inside while loop")

                delay(1000)
                //emit(LiveDataResource.Success( )


                emit(RequestResource.Success( Login(status = Login.Status(code =""+i  , msg = "Done"), firstLogin = 0) ))

                delay(1000)
                i++
            }
            Log.e("DoLoginAndSaveResponseUseCase" , "after while loop")


            /* if (getLogin?.isDataValid() == false) {
                 emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
             } else if (getLogin?.status?.code == "200") {
                 emit(RequestResource.Success(getLogin))
             } else {
                 emit(RequestResource.ErrorResponse(message = getLogin?.status?.msg))
             }*/
        } catch (e: HttpException) {
            Log.e("DoLoginAndSaveResponseUseCase" , "HttpException")

            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            Log.e("DoLoginAndSaveResponseUseCase" , "IOException")

            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}