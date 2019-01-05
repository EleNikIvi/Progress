package com.eugene.progress.ui.main.week

import com.eugene.progress.ui.base.BasePresenter

class MainWeekPresenter(interactor: MainWeekContract.Interactor) :
    BasePresenter<MainWeekContract.View, MainWeekContract.Interactor>(interactor), MainWeekContract.Presenter
