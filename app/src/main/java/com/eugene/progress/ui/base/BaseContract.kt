package com.eugene.progress.ui.base

interface BaseContract {

    interface View

    interface Presenter<V : BaseContract.View, I : BaseContract.Interactor> {

        fun onAttach(view: V?)

        fun onDetach()

        fun getView(): V?
    }

    interface Interactor
}
