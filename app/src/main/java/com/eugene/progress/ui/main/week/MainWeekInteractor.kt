package com.eugene.progress.ui.main.week

import com.eugene.progress.domain.enum.TimePeriod
import com.eugene.progress.domain.service.TimeServiceContract
import com.eugene.progress.ui.base.BaseInteractor

class MainWeekInteractor(private val timeService: TimeServiceContract) :
    BaseInteractor(), MainWeekContract.Interactor {

    override fun getProgressPercentages(): Int {

        return timeService.getProgressPercentages(TimePeriod.DAY)
    }
}
