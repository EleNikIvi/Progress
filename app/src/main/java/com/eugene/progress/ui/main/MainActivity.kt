package com.eugene.progress.ui.main

import android.os.Bundle
import com.eugene.progress.R
import com.eugene.progress.ui.base.BaseActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(), MainContract.View {

    private val presenter: MainContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        presenter.onAttached(this)
    }

    override fun onDestroy() {

        presenter.onDetached()

        super.onDestroy()
    }
}
