package com.eugene.progress.ui.main.week

import com.eugene.progress.ui.base.BasePresenter

class MainWeekPresenter(interactor: MainWeekContract.Interactor) :
    BasePresenter<MainWeekContract.View, MainWeekContract.Interactor>(interactor), MainWeekContract.Presenter {

    override fun onAttach(view: MainWeekContract.View?) {
        super.onAttach(view)

        view?.fillTimeTable(interactor?.getProgressPercentages() ?: 0)
    }
}
