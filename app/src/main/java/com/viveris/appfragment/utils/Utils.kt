package com.viveris.appfragment.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun dateToString(dateSec: Int?): String {
        var res = ""
        dateSec?.let {
            val calendar = Calendar.getInstance().apply {
                timeInMillis = dateSec * 1000L
            }
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            res = dateFormat.format(calendar.time)
        }
        return res
    }
}