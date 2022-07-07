package com.example.weatheralerts.userInterface

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.AdapterView
import com.example.weatheralerts.R

class StatesSpinnerActivity(private val viewModel: MainViewModel, private val context: Context) : Activity(), AdapterView.OnItemSelectedListener {

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val stateIdentifiers = context.resources.getStringArray(R.array.abbreviated_states_array)
        viewModel.getNwsData(stateIdentifiers[p2])
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}