package com.eugene.progress.domain.service

import com.eugene.progress.domain.enum.TimePeriod

interface TimeServiceContract {

    fun getPercentOfProgress(timePeriod: TimePeriod): Int
}
