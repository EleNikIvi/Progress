package com.eugene.progress.ui.main.month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.progress.R
import com.eugene.progress.ui.base.BaseFragment
import kotlinx.android.synthetic.main.view_time_table.*
import org.koin.android.ext.android.inject

class MainMonthFragment :
    BaseFragment(), MainMonthContract.View {

    private val presenter: MainMonthContract.Presenter by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_month, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter.onAttach(this)

        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun onDestroyView() {

        presenter.onDetach()

        super.onDestroyView()
    }


    override fun fillTimeTable(percentages: Int) {

        txt_percentages.text = String.format(getString(R.string.main_percentages), percentages)
    }


    private fun initView() {

        txt_period.text = getString(R.string.month)
    }
}
