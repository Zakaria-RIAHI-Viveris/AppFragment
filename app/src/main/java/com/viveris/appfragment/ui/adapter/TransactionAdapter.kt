package com.viveris.appfragment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viveris.appfragment.R
import com.viveris.appfragment.model.Transaction
import kotlinx.android.synthetic.main.item_transaction.view.*

class TransactionAdapter(
        private val context: Context,
        private val transactionList: List<Transaction>
) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_transaction, parent, false))

    override fun getItemCount() = transactionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }

    private fun getItem(position: Int) = transactionList[position]

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(transaction: Transaction?) {
            itemView.apply {
                transaction?.let {
                    text_view_info_transaction.text = transaction.label + " " + transaction.value
                }
            }
        }
    }
}