package com.asacoding.dolphin_architecture.presentation.main.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asacoding.dolphin_architecture.R
import com.asacoding.dolphin_architecture.common.base.activity.BaseActivity
import com.asacoding.dolphin_architecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    @Inject
    lateinit var exampleString: String
    override fun inflateBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun getAnimationPopUpView(): Pair<Int, Int> {
        return Pair(R.anim.slide_in_from_bottom, R.anim.slide_out_to_top)
    }

    override fun getContainer(): Int {
        return R.id.main_container
    }

    override fun initializeViews() {
        Log.e("aaaasda" , "aaa "+ exampleString)
    }

}