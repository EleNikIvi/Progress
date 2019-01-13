package com.eugene.progress.domain.service

import com.eugene.progress.domain.enum.TimePeriod
import java.util.*

class TimeService : TimeServiceContract {

    val MILLISECONDS_IN_MINUTE: Long = 60000
    val MINUTES_IN_DAY: Long = 1440


    override fun getPercentOfProgress(timePeriod: TimePeriod): Int {

        val cal = Calendar.getInstance()

        val currentPosition = cal.timeInMillis

        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)

        val startPositionOfDay = cal.timeInMillis

        val dayProgressInMinutes = (currentPosition - startPositionOfDay) / MILLISECONDS_IN_MINUTE

        var currentMinutes: Long = 0
        var totalMinutes: Long = 0

        when (timePeriod) {
            TimePeriod.DAY -> {

                currentMinutes = dayProgressInMinutes
                totalMinutes = MINUTES_IN_DAY
            }
            TimePeriod.WEEK -> {

                currentMinutes = ((cal.get(Calendar.DAY_OF_WEEK) - 1) * MINUTES_IN_DAY) + dayProgressInMinutes
                totalMinutes = 7 * MINUTES_IN_DAY
            }
            TimePeriod.MONTH -> {

                currentMinutes = ((cal.get(Calendar.DAY_OF_MONTH) - 1) * MINUTES_IN_DAY) + dayProgressInMinutes
                totalMinutes = cal.getActualMaximum(Calendar.DAY_OF_MONTH) * MINUTES_IN_DAY
            }
            TimePeriod.YEAR -> {

                currentMinutes = ((cal.get(Calendar.DAY_OF_YEAR) - 1) * MINUTES_IN_DAY) + dayProgressInMinutes
                totalMinutes = cal.getActualMaximum(Calendar.DAY_OF_YEAR) * MINUTES_IN_DAY
            }
        }

        return (currentMinutes * 100 / totalMinutes).toInt()
    }
}
