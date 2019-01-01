package com.eugene.progress.ui.base

abstract class BasePresenter<V : BaseContract.View, I : BaseContract.Interactor>(private var interactor: I?) :
    BaseContract.Presenter<V, I> {

    private var view: V? = null


    override fun onAttach(view: V?) {

        this.view = view
    }

    override fun onDetach() {

        view = null
        interactor = null
    }

    override fun getView(): V? {

        return this.view
    }
}
