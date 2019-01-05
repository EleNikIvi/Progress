package com.eugene.progress.ui.main

import com.eugene.progress.ui.base.BaseContract

interface MainContract : BaseContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View, Interactor>

    interface Interactor : BaseContract.Interactor
}
