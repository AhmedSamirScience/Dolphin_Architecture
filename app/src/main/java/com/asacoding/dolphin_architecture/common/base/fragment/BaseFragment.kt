package com.asacoding.dolphin_architecture.common.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.asacoding.dolphin_architecture.common.base.BaseViewModel

/**
 * Base class for all fragments in the application.
 * This class provides common functionality such as view initialization, lifecycle management, etc.
 * @param VM The type of ViewModel associated with the fragment.
 * @param VB The type of ViewDataBinding associated with the fragment's layout.
 */
abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding>(baseViewModel: VM) : ViewHandlerFragment<VM>(baseViewModel), View.OnClickListener {

    /** ViewDataBinding instance for the fragment's layout */
    lateinit var baseViewBinding: VB

    //region Initialization
    /**
     * Gets the layout resource ID for the fragment.
     * Subclasses must override this method to provide the layout resource ID.
     * @return Layout resource ID.
     */
    protected abstract fun getContentView(): Int

    /**
     * Subscribes to LiveData updates.
     * Subclasses must override this method to observe LiveData objects.
     */
    protected abstract fun subscribeLiveData()

    /**
     * Initializes the views of the fragment.
     * Subclasses must override this method to set up views.
     */
    protected abstract fun initializeViews()
    //endregion

    //region Fragment Lifecycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseViewBinding = DataBindingUtil.inflate(inflater, getContentView(), container, false)
        return baseViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        subscribeLiveData()
    }
    //endregion
}
