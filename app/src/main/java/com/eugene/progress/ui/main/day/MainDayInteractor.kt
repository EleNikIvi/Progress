package com.eugene.progress.ui.main.day

import com.eugene.progress.domain.enum.TimePeriod
import com.eugene.progress.domain.service.TimeServiceContract
import com.eugene.progress.ui.base.BaseInteractor

class MainDayInteractor(private val timeService: TimeServiceContract) :
    BaseInteractor(), MainDayContract.Interactor {

    override fun getProgressPercentages(): Int {

        return timeService.getProgressPercentages(TimePeriod.DAY)
    }
}
