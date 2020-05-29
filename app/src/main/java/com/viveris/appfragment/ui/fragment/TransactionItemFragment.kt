package com.viveris.appfragment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.viveris.appfragment.R
import com.viveris.appfragment.model.Transaction
import com.viveris.appfragment.ui.adapter.TransactionAdapter
import kotlinx.android.synthetic.main.fragment_transaction_item.*
import java.io.Serializable

class TransactionItemFragment : Fragment() {
    private var transactionList: List<Transaction> = listOf()

    // Store instance variables based on arguments passed
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        transactionList = arguments?.let {
            it.getSerializable(BUNDLE_LIST) as List<Transaction>
        }?: listOf()
    }

    // Inflate the view for the fragment based on layout XML
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_transaction_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_view_transaction_history?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = TransactionAdapter(context, transactionList)
        }
    }

    companion object {
        private const val BUNDLE_LIST = "LIST"
        fun newInstance(transactionList: List<Transaction>) = TransactionItemFragment().apply {
            arguments = Bundle().apply {
                putSerializable(BUNDLE_LIST, transactionList as Serializable)
            }
        }
    }
}