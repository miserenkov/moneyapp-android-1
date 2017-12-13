package com.cactusteam.money.ui.widget.period

import android.content.Context
import com.cactusteam.money.R
import com.cactusteam.money.data.period.Period

/**
 * @author vpotapenko
 */
class LastMonthReportPeriod(context: Context) : BaseReportPeriod(context) {

    override fun calculatePeriod() {
        val period = Period.getLastMonthPeriod()
        _startDate = period.first
        _endDate = period.second
    }

    override fun getTitle(): String {
        return context.getString(R.string.last_month)
    }
}
