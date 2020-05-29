package com.viveris.appfragment.ui.fragment

import androidx.fragment.app.Fragment
import com.viveris.appfragment.ui.listener.NavigationListener

abstract class AbstractBaseFragment : Fragment() {

    @JvmField
    protected var listener: NavigationListener? = null

    fun setNavigationListener(listener: NavigationListener?) {
        this.listener = listener
    }
}