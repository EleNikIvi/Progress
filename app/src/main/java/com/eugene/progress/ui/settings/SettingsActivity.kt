package com.eugene.progress.ui.settings

import android.os.Bundle
import com.eugene.progress.R
import com.eugene.progress.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_settings.*
import org.koin.android.ext.android.inject

class SettingsActivity : BaseActivity(), SettingsContract.View {

    private val presenter: SettingsContract.Presenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        initView()

        presenter.onAttach(this)
    }

    override fun onDestroy() {

        presenter.onDetach()

        super.onDestroy()
    }


    override fun onSupportNavigateUp(): Boolean {

        presenter.onBackButtonClicked()

        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()

        presenter.onBackButtonClicked()
    }


    override fun showPreviousView() {

        this.finish()
    }


    private fun initView() {

        setSupportActionBar(tlb__settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.settings)
    }
}
