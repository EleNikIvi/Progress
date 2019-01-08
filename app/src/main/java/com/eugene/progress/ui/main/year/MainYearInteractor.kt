package com.eugene.progress.ui.main.year

import com.eugene.progress.domain.enum.TimePeriod
import com.eugene.progress.domain.service.TimeServiceContract
import com.eugene.progress.ui.base.BaseInteractor

class MainYearInteractor(private val timeService: TimeServiceContract) :
    BaseInteractor(), MainYearContract.Interactor {

    override fun getProgressPercentages(): Int {

        return timeService.getProgressPercentages(TimePeriod.DAY)
    }
}
