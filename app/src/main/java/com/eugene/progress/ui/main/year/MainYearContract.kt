package com.eugene.progress.ui.main.year

import com.eugene.progress.ui.base.BaseContract

interface MainYearContract : BaseContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View, Interactor>

    interface Interactor : BaseContract.Interactor
}
