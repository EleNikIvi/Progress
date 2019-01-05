package com.eugene.progress.ui.main.year

import com.eugene.progress.ui.base.BasePresenter

class MainYearPresenter(interactor: MainYearContract.Interactor) :
    BasePresenter<MainYearContract.View, MainYearContract.Interactor>(interactor), MainYearContract.Presenter
