package com.eugene.progress.ui.main

import com.eugene.progress.ui.base.BasePresenter

class MainPresenter(interactor: MainContract.Interactor) :
    BasePresenter<MainContract.View, MainContract.Interactor>(interactor), MainContract.Presenter {

    override fun onSettingsMenuItemClicked() {

        view?.showSettingsView()
    }
}
