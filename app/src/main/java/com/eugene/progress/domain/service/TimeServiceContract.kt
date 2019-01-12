package com.eugene.progress.domain.service

import com.eugene.progress.domain.enum.TimePeriod

interface TimeServiceContract {

    fun getProgressPercent(timePeriod: TimePeriod): Int

    fun getRemainingPercent(timePeriod: TimePeriod): Int
}
