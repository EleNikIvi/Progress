package com.eugene.progress.ui.main.month

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
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


    override fun fillTimeTable(percent: Int) {

        val percentProgress = SpannableStringBuilder(String.format(getString(R.string.main_percentages), percent))

        percentProgress.setSpan(
            AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.textSizePercentSign)),
            percentProgress.length - 1,
            percentProgress.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )

        txt_percent.text = percentProgress
    }


    private fun initView() {

        txt_period.text = getString(R.string.month)
    }
}
