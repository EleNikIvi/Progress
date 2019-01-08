package com.eugene.progress.domain.service

import com.eugene.progress.domain.enum.TimePeriod

interface TimeServiceContract {

    fun getProgressPercentages(timePeriod: TimePeriod): Int

    fun getRemainingPercentages(timePeriod: TimePeriod): Int
}
