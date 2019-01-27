package com.eugene.progress.ui.settings

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceFragmentCompat
import com.eugene.progress.BuildConfig
import com.eugene.progress.R
import com.eugene.progress.data.prefs.SharedPreferences
import com.eugene.progress.domain.manager.SettingsManagerContract
import com.eugene.progress.ui.base.BaseActivity
import org.koin.android.ext.android.inject

class SettingsActivity : BaseActivity(), SettingsContract.View {

    private val presenter: SettingsContract.Presenter by inject()

    private var tlbSettings: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        if (supportFragmentManager.findFragmentById(android.R.id.content) == null) {

            supportFragmentManager.beginTransaction()
                .add(R.id.frm_content, SettingsFragment()).commit()
        }

        initView()

        presenter.onAttach(this)
    }

    override fun onDestroy() {

        presenter.onDetach()

        destroyView()

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

        tlbSettings = findViewById(R.id.tlb__settings)

        setSupportActionBar(tlbSettings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.global__settings)
    }

    private fun destroyView() {

        tlbSettings = null
    }


    class SettingsFragment : PreferenceFragmentCompat() {

        private val settingsManager: SettingsManagerContract by inject()


        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            addPreferencesFromResource(R.xml.settings)

            val appTheme = findPreference("settings__app_theme")
            appTheme?.summary = getThemeName(settingsManager.getThemeId())
            appTheme.setOnPreferenceChangeListener { _, newValue ->
                appTheme?.summary = getThemeName(newValue as String)
                true
            }

            val appVersion = findPreference("settings__app_version")
            appVersion?.summary = String.format(
                getString(R.string.settings__app_version_description),
                "${BuildConfig.VERSION_NAME}.${BuildConfig.VERSION_CODE}"
            )
        }


        private fun getThemeName(themeId: String): String {

            return when (themeId) {
                "1" -> getString(R.string.app_theme__mint)
                "2" -> getString(R.string.app_theme__sky)
                "3" -> getString(R.string.app_theme__cherry)
                else -> getString(R.string.app_theme__space)
            }
        }
    }
}
