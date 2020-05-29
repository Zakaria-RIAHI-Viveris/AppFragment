package com.viveris.appfragment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viveris.appfragment.R

class SettingsFragment : AbstractBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        initializeScreenView(view)
        return view
    }

    private fun initializeScreenView(view: View) {}
}