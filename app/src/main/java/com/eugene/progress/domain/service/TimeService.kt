package com.eugene.progress.domain.service

import com.eugene.progress.domain.enum.TimePeriod

class TimeService : TimeServiceContract {

    override fun getProgressPercent(timePeriod: TimePeriod): Int {

        return 0
    }

    override fun getRemainingPercent(timePeriod: TimePeriod): Int {

        return 0
    }
}
