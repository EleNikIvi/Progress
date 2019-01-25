package com.eugene.progress.ui.main.year

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eugene.progress.R
import com.eugene.progress.ui.base.BaseFragment
import org.koin.android.ext.android.inject

class MainYearFragment
    : BaseFragment(), MainYearContract.View {

    private val presenter: MainYearContract.Presenter by inject()

    private var txtPeriod: TextView? = null
    private var txtPercent: TextView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_year, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initView()

        presenter.onAttach(this)
    }

    override fun onDestroyView() {

        presenter.onDetach()

        destroyView()

        super.onDestroyView()
    }


    override fun fillTimeTable(percent: Int) {

        val percentProgress = SpannableStringBuilder(String.format(getString(R.string.main__percentages), percent))

        percentProgress.setSpan(
            AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.textSizePercentSign)),
            percentProgress.length - 1,
            percentProgress.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )

        txtPercent?.text = percentProgress
    }


    private fun initView() {

        txtPeriod = view?.findViewById(R.id.txt_period)
        txtPercent = view?.findViewById(R.id.txt_percent)

        txtPeriod?.text = getString(R.string.global__year)
    }

    private fun destroyView() {

        txtPeriod = null
        txtPercent = null
    }
}
