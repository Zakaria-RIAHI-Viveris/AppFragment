package com.viveris.appfragment.computer

import com.viveris.appfragment.model.Transaction
import com.viveris.appfragment.model.TransactionType

class TransactionComputer {

    fun getTransactionsType(transactionType: TransactionType?, transactionList: List<Transaction>?): List<Transaction> {
        var res: MutableList<Transaction> = mutableListOf()
        if (transactionType != null && !transactionList.isNullOrEmpty()) {
            for (transaction in transactionList) {
                if (transactionType == transaction.transactionType) {
                    res.add(transaction)
                }
            }
        }
        return res
    }
}