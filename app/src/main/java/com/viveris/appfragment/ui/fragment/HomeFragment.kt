package com.viveris.appfragment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viveris.appfragment.R
import com.viveris.appfragment.utils.Utils
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : AbstractBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_date.text = Utils.dateToString(Date().time.toInt())
        btn_transactions.setOnClickListener { listener?.onItemSlected(R.id.nav_transactions, getString(R.string.transactions)) }
    }
}