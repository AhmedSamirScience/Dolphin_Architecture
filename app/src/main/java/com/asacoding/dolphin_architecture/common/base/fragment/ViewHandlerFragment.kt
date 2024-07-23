package com.asacoding.dolphin_architecture.common.base.fragment

import android.os.Bundle
import android.view.View
import com.asacoding.dolphin_architecture.common.base.BaseViewModel

/**
 * Abstract class to handle enabling and disabling all views in a fragment.
 */
abstract class ViewHandlerFragment<VM : BaseViewModel>(baseViewModel: VM) : LifecycleHandlerFragment<VM>(baseViewModel) {

    //region disable and enable All views
    private lateinit var allViews: List<View>
    protected abstract fun getAllViews(): List<View>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allViews = getAllViews()
    }

    fun disableAllViews() {
        for (item in allViews) {
            item.isEnabled = false
        }
    }

    fun enableAllViews() {
        for (item in allViews) {
            item.isEnabled = true
        }
    }
    //endregion
}
