package com.viveris.appfragment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viveris.appfragment.R
import com.viveris.appfragment.computer.TransactionComputer
import com.viveris.appfragment.model.Transaction
import com.viveris.appfragment.model.TransactionType
import com.viveris.appfragment.ui.adapter.TransactionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_transactions.*

class TransactionsFragment : AbstractBaseFragment() {

    private var transactionList: MutableList<Transaction> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_transactions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transactionComputer = TransactionComputer()
        context?.let {
            val pagerAdapter = TransactionsPagerAdapter(childFragmentManager, it)
            pagerAdapter.setTransactionsCredit(transactionComputer.getTransactionsType(TransactionType.CREDIT, transactionList))
            pagerAdapter.setTransactionsDebit(transactionComputer.getTransactionsType(TransactionType.DEBIT, transactionList))

            pager_history.adapter = pagerAdapter
            tabs_history.setupWithViewPager(pager_history)
        }
    }

    private fun initData() {
        transactionList.add(Transaction("loyer", "600€", TransactionType.DEBIT))
        transactionList.add(Transaction("internet", "20€", TransactionType.DEBIT))
        transactionList.add(Transaction("edf", "50€", TransactionType.DEBIT))
        transactionList.add(Transaction("téléphone", "25€", TransactionType.DEBIT))
        transactionList.add(Transaction("facture auchan", "53€", TransactionType.DEBIT))
        transactionList.add(Transaction("salaire", "2222€", TransactionType.CREDIT))
        transactionList.add(Transaction("cinéma", "11€", TransactionType.DEBIT))
        transactionList.add(Transaction("fnac", "129€", TransactionType.DEBIT))
        transactionList.add(Transaction("divers", "23€", TransactionType.DEBIT))
        transactionList.add(Transaction("virement", "300€", TransactionType.CREDIT))
        transactionList.add(Transaction("divers", "34€", TransactionType.DEBIT))
        transactionList.add(Transaction("divers", "100€", TransactionType.DEBIT))
    }
}