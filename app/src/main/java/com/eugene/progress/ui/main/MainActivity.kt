package com.eugene.progress.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.eugene.progress.R
import com.eugene.progress.ui.base.BaseActivity
import com.eugene.progress.ui.base.BaseFragment
import com.eugene.progress.ui.main.day.MainDayFragment
import com.eugene.progress.ui.main.month.MainMonthFragment
import com.eugene.progress.ui.main.week.MainWeekFragment
import com.eugene.progress.ui.main.year.MainYearFragment
import com.eugene.progress.ui.settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(), MainContract.View {

    private val presenter: MainContract.Presenter by inject()

    private var tlbMain: Toolbar? = null
    private var bnvMain: BottomNavigationView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initView()

        presenter.onAttach(this)
    }

    override fun onResume() {
        super.onResume()

        setupView()
    }

    override fun onPause() {

        terminateView()

        super.onPause()
    }

    override fun onDestroy() {

        presenter.onDetach()

        destroyView()

        super.onDestroy()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menu_main_toolbar, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.itm_settings -> {

                presenter.onSettingsMenuItemClicked()

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


    override fun showSettingsView() {

        startActivity(Intent(this, SettingsActivity::class.java))
    }


    private fun initView() {

        tlbMain = findViewById(R.id.tlb__main)
        bnvMain = findViewById(R.id.bnv_main)

        setSupportActionBar(tlbMain)
        supportActionBar?.title = ""

        setContentFragment(MainDayFragment())
    }

    private fun setupView() {

        bnvMain?.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.itm_day -> {

                    setContentFragment(MainDayFragment())
                    true
                }
                R.id.itm_week -> {

                    setContentFragment(MainWeekFragment())
                    true
                }
                R.id.itm_month -> {

                    setContentFragment(MainMonthFragment())
                    true
                }
                R.id.itm_year -> {

                    setContentFragment(MainYearFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun terminateView() {

        bnvMain?.setOnNavigationItemSelectedListener(null)
    }

    private fun destroyView() {

        tlbMain = null
        bnvMain = null
    }

    private fun setContentFragment(fragment: BaseFragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frm_content, fragment)
            .commit()
    }
}
