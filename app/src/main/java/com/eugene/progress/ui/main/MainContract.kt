package com.eugene.progress.ui.main

import com.eugene.progress.ui.base.BaseContract

interface MainContract : BaseContract {

    interface View : BaseContract.View {

        fun showSettingsView()
    }

    interface Presenter : BaseContract.Presenter<View, Interactor> {

        fun onSettingsMenuItemClicked()
    }

    interface Interactor : BaseContract.Interactor
}
