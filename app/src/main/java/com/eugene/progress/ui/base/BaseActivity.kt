package com.eugene.progress.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eugene.progress.R
import com.eugene.progress.domain.manager.SettingsManagerContract
import org.koin.android.ext.android.inject

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    protected val settingsManager: SettingsManagerContract by inject()

    private var appThemeId: String = "0"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appThemeId = settingsManager.getAppThemeId()
        setAppTheme(appThemeId)
    }

    override fun onResume() {
        super.onResume()

        if (appThemeId != settingsManager.getAppThemeId()) {
            recreate()
        }
    }


    private fun setAppTheme(appThemeId: String) {

        when (appThemeId) {
            "1" -> setTheme(R.style.AppTheme_Mint)
            "2" -> setTheme(R.style.AppTheme_Sky)
            "3" -> setTheme(R.style.AppTheme_Cherry)
            else -> setTheme(R.style.AppTheme_Space)
        }
    }
}
