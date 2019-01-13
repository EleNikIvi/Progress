package com.eugene.progress.ui.settings

import com.eugene.progress.ui.base.BaseContract

interface SettingsContract : BaseContract {

    interface View : BaseContract.View {

        fun showPreviousView()
    }

    interface Presenter : BaseContract.Presenter<View, Interactor> {

        fun onBackButtonClicked()
    }

    interface Interactor : BaseContract.Interactor
}
