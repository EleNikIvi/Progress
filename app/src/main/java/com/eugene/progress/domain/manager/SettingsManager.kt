package com.eugene.progress.domain.manager

import com.eugene.progress.data.prefs.SharedPreferences

class SettingsManager(private val prefs: SharedPreferences) : SettingsManagerContract {

    override fun getAppThemeId(): String {

        return prefs.getString("settings__app_theme", "0")
    }
}
