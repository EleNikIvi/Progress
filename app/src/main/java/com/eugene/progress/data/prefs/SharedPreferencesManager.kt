package com.eugene.progress.data.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPreferencesManager(context: Context, name: String) {

    private val sharedPreferences: SharedPreferences by lazy {

        if (name.isEmpty()) {
            PreferenceManager.getDefaultSharedPreferences(context)
        } else {
            context.getSharedPreferences(name, Context.MODE_PRIVATE)
        }
    }


    fun putBoolean(key: String, value: Boolean) {

        sharedPreferences.edit()?.putBoolean(key, value)?.apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        sharedPreferences.getBoolean(key, defaultValue)

    fun putInt(key: String, value: Int) {

        sharedPreferences.edit()?.putInt(key, value)?.apply()
    }

    fun getInt(key: String, defaultValue: Int): Int =
        sharedPreferences.getInt(key, defaultValue)

    fun putLong(key: String, value: Long) {

        sharedPreferences.edit()?.putLong(key, value)?.apply()
    }

    fun getLong(key: String, defaultValue: Long): Long =
        sharedPreferences.getLong(key, defaultValue)

    fun putFloat(key: String, value: Float) {

        sharedPreferences.edit()?.putFloat(key, value)?.apply()
    }

    fun getFloat(key: String, defaultValue: Float): Float =
        sharedPreferences.getFloat(key, defaultValue)

    fun putString(key: String, value: String) {

        sharedPreferences.edit()?.putString(key, value)?.apply()
    }

    fun getString(key: String, defaultValue: String): String =
        sharedPreferences.getString(key, defaultValue)

    fun putStringSet(key: String, value: List<String>) {

        val set = HashSet<String>()
        set.addAll(value)

        sharedPreferences.edit()?.putStringSet(key, set)?.apply()
    }

    fun getStringSet(key: String): MutableSet<String>? =
        sharedPreferences.getStringSet(key, HashSet<String>())


    private fun clearAll() {

        sharedPreferences.edit()?.clear()?.apply()
    }
}