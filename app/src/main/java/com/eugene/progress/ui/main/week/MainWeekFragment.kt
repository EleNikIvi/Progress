package com.eugene.progress.ui.main.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.progress.R
import com.eugene.progress.ui.base.BaseFragment
import org.koin.android.ext.android.inject

class MainWeekFragment : BaseFragment(), MainWeekContract.View {

    private val presenter: MainWeekContract.Presenter by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_week, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter.onAttach(this)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {

        presenter.onDetach()

        super.onDestroyView()
    }
}