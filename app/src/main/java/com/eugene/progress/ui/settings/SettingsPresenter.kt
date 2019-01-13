package com.eugene.progress.ui.settings

import com.eugene.progress.ui.base.BasePresenter

class SettingsPresenter(interactor: SettingsContract.Interactor) :
    BasePresenter<SettingsContract.View, SettingsContract.Interactor>(interactor), SettingsContract.Presenter {

    override fun onBackButtonClicked() {

        view?.showPreviousView()
    }
}
