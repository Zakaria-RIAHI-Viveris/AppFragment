package com.viveris.appfragment.model

enum class TransactionType(var type: String) {
    DEBIT("DEBIT"), CREDIT("CREDIT");

    override fun toString(): String {
        return type
    }

}