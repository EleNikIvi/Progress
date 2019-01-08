package com.eugene.progress.ui.main.week

import com.eugene.progress.ui.base.BaseContract

interface MainWeekContract : BaseContract {

    interface View : BaseContract.View {

        fun fillTimeTable(percentages: Int)
    }

    interface Presenter : BaseContract.Presenter<View, Interactor>

    interface Interactor : BaseContract.Interactor {

        fun getProgressPercentages(): Int
    }
}
