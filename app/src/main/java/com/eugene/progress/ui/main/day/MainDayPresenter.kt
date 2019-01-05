package com.eugene.progress.ui.main.day

import com.eugene.progress.ui.base.BasePresenter

class MainDayPresenter(interactor: MainDayContract.Interactor) :
    BasePresenter<MainDayContract.View, MainDayContract.Interactor>(interactor), MainDayContract.Presenter
