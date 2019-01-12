package com.eugene.progress.ui.main.day

import com.eugene.progress.ui.base.BaseContract

interface MainDayContract : BaseContract {

    interface View : BaseContract.View {

        fun fillTimeTable(percent: Int)
    }

    interface Presenter : BaseContract.Presenter<View, Interactor>

    interface Interactor : BaseContract.Interactor {

        fun getProgressPercentages(): Int
    }
}
