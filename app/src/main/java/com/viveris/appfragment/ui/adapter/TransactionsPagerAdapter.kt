package com.viveris.appfragment.ui.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.viveris.appfragment.R
import com.viveris.appfragment.model.Transaction
import com.viveris.appfragment.ui.fragment.TransactionItemFragment

class TransactionsPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var transactionsCredit: List<Transaction> = listOf()
    private var transactionsDebit: List<Transaction> = listOf()

    companion object {
        const val NUM_ITEMS = 2
    }

    override fun getItem(position: Int): TransactionItemFragment = when (position == 0) {
        true -> TransactionItemFragment.newInstance(transactionsCredit)
        else -> TransactionItemFragment.newInstance(transactionsDebit)
    }

    override fun getPageTitle(position: Int) = when (position) {
        0 -> context.getString(R.string.credit, transactionsCredit.size)
        else -> context.getString(R.string.debit, transactionsDebit.size)
    }

    override fun getCount() = NUM_ITEMS

    fun setTransactionsCredit(transactionsCredit: List<Transaction>) {
        this.transactionsCredit = transactionsCredit
    }

    fun setTransactionsDebit(transactionsDebit: List<Transaction>) {
        this.transactionsDebit = transactionsDebit
    }

}