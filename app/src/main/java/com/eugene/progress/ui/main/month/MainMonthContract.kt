package com.eugene.progress.ui.main.month

import com.eugene.progress.ui.base.BaseContract

interface MainMonthContract : BaseContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View, Interactor>

    interface Interactor : BaseContract.Interactor
}
