package com.asacoding.dolphin_architecture.common.utils.widget

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


object SpinnerAdapter {
  /*  fun setSpinnerAdapter(
        data: List<*>,
        spinnerAdapter: Spinner,
        requiredContext: Context,
        takeAction: ((Int) -> Unit)
    ) {

        val adapter = ArrayAdapter(requiredContext, R.layout.layout_spinner_item, data)
        adapter.setDropDownViewResource(R.layout.layout_spinner_item)
        spinnerAdapter.adapter = adapter
        spinnerAdapter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position >= 0) {
                    takeAction.invoke(position)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }*/
}