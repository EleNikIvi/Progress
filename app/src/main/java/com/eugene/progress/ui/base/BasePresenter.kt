package com.eugene.progress.ui.base

abstract class BasePresenter<V : BaseContract.View, I : BaseContract.Interactor>(protected var interactor: I?) :
    BaseContract.Presenter<V, I> {

    protected var view: V? = null
        private set


    override fun onAttach(view: V?) {

        this.view = view
    }

    override fun onDetach() {

        view = null
        interactor = null
    }
}
