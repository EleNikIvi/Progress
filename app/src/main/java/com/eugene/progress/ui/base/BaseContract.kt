package com.eugene.progress.ui.base

interface BaseContract {

    interface View

    interface Presenter<V : BaseContract.View, I : BaseContract.Interactor> {

        fun onAttached(view: V?)

        fun onDetached()

        fun getView(): V?
    }

    interface Interactor
}
