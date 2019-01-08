package com.eugene.progress.ui.main.month

import com.eugene.progress.ui.base.BasePresenter

class MainMonthPresenter(interactor: MainMonthContract.Interactor) :
    BasePresenter<MainMonthContract.View, MainMonthContract.Interactor>(interactor), MainMonthContract.Presenter {

    override fun onAttach(view: MainMonthContract.View?) {
        super.onAttach(view)

        view?.fillTimeTable(interactor?.getProgressPercentages() ?: 0)
    }
}
