package com.eugene.progress.ui.main.year

import com.eugene.progress.ui.base.BaseContract

interface MainYearContract : BaseContract {

    interface View : BaseContract.View {

        fun fillTimeTable(percentages: Int)
    }

    interface Presenter : BaseContract.Presenter<View, Interactor>

    interface Interactor : BaseContract.Interactor {

        fun getProgressPercentages(): Int
    }
}
