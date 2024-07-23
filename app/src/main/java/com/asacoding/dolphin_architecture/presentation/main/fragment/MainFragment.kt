package com.asacoding.dolphin_architecture.presentation.main.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.asacoding.dolphin_architecture.R
import com.asacoding.dolphin_architecture.common.base.fragment.BaseFragment
import com.asacoding.dolphin_architecture.common.stateHandling.uI.LiveDataResource
import com.asacoding.dolphin_architecture.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment :  BaseFragment<MainViewModel, FragmentMainBinding>(MainViewModel())    {

   @Inject
    lateinit var exampleString: String
    //region initialization
    override fun getContentView(): Int {
        return R.layout.fragment_main
    }
    override fun getAllViews(): List<View> {
        return listOf<View>(baseViewBinding. qqqqqq)
    }
    override fun initializeViewModel() {
        val viewModel: MainViewModel by viewModels()
        baseViewModel = viewModel
    }
    override fun subscribeLiveData() {
        doLoginObserver()
    }
    override fun initializeViews() {
       Log.e("aawqaasda" , "bbbbb "+ exampleString)
    }
    //endregion

    override fun onClick(v: View?) {

    }


    //region life cycle of the application
    override fun start() {
        //TextInputEditTextUtils.clearTextForAllInputEditText(listOf(baseViewBinding.edtPass, baseViewBinding.edtUserName))

    }
    override fun stopAndReset() {}
    //endregion

    private fun doLoginObserver() {



        //region state flow
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                baseViewModel?.currentLoginState?.collect { result ->
                    when (result) {
                        is LiveDataResource.Success -> {
                            Log.e("doLoginObserver", "Success ${result.data?.status?.code}")
                        }
                        is LiveDataResource.ErrorResponse -> {
                            Log.e("doLoginObserver", "ErrorResponse ${result.message}")
                        }
                        is LiveDataResource.Error -> {
                            Log.e("doLoginObserver", "Error ${result.message}")
                        }
                        is LiveDataResource.Loading -> {
                            Log.e("doLoginObserver", "Loading")
                        }
                    }
                }
            }
        }
        //endregion

        //region mutable state flow
        /*viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                baseViewModel?.doLoginStateFlow?.collect { result ->

                        when (result) {
                            is LiveDataResource.Success -> {
                                Log.e("doLoginObserver", "Success ${result.data?.status?.code}")
                            }
                            is LiveDataResource.ErrorResponse -> {
                                Log.e("doLoginObserver", "ErrorResponse ${result.message}")
                            }
                            is LiveDataResource.Error -> {
                                Log.e("doLoginObserver", "Error ${result.message}")
                            }
                            is LiveDataResource.Loading -> {
                                Log.e("doLoginObserver", "Loading")
                            }
                        }

                }
            }
        }*/
        //endregion

    }

}