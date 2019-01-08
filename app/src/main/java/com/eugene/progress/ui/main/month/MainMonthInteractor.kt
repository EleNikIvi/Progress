package com.eugene.progress.ui.main.month

import com.eugene.progress.domain.enum.TimePeriod
import com.eugene.progress.domain.service.TimeServiceContract
import com.eugene.progress.ui.base.BaseInteractor

class MainMonthInteractor(private val timeService: TimeServiceContract) :
    BaseInteractor(), MainMonthContract.Interactor {

    override fun getProgressPercentages(): Int {

        return timeService.getProgressPercentages(TimePeriod.DAY)
    }
}
