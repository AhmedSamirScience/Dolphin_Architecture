package com.asacoding.dolphin_architecture.presentation.main.fragment

import Login
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asacoding.dolphin_architecture.DoLoginAndSaveResponseUseCase
import com.asacoding.dolphin_architecture.common.base.BaseViewModel
import com.asacoding.dolphin_architecture.common.stateHandling.uI.LiveDataResource
import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class MainViewModel : BaseViewModel() {
    override fun stop() {


    }

    override fun start() {

    }

    //region StateFlow
    private val doLoginUseCase: DoLoginAndSaveResponseUseCase = DoLoginAndSaveResponseUseCase()

    var  currentLoginState: StateFlow<LiveDataResource<Login>> = doLoginUseCase()
        .map { resultResponse ->
            when (resultResponse) {
                is RequestResource.Success -> {
                    LiveDataResource.Success(resultResponse.data)
                }
                is RequestResource.ErrorResponse -> {
                    LiveDataResource.ErrorResponse(message = resultResponse.message.toString())
                }
                is RequestResource.Error -> {
                    LiveDataResource.Error(message = resultResponse.message.toString())
                }
            }
        }
        .onStart {
            // emit(LiveDataResource.Loading())
            Log.e("BlankViewModel", "onStart")
        }
        .onCompletion {
            Log.e("BlankViewModel", "onCompletion")
        }
        .catch { exception ->
            emit(LiveDataResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري"))
            Log.e("BlankViewModel", "catch ${exception.message}")
        }
        .onEach { it ->
            Log.e("BlankViewModel", "onEach  ${it.data}")
        }
        .stateIn(
            scope = viewModelScope ,
            initialValue = LiveDataResource.Loading(),
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000)
        )
    //endregion

}