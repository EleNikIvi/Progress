package com.eugene.progress.ui.main.month

import com.eugene.progress.ui.base.BasePresenter

class MainMonthPresenter(interactor: MainMonthContract.Interactor) :
    BasePresenter<MainMonthContract.View, MainMonthContract.Interactor>(interactor), MainMonthContract.Presenter
