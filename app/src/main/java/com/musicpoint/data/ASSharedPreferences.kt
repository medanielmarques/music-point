package com.musicpoint.data

import android.content.Context
import android.content.SharedPreferences

class ASSharedPreferences(private val context: Context) {
    private val sharedPref: SharedPreferences
    private val username = "username"

    init {
        sharedPref = context.getSharedPreferences(username, Context.MODE_PRIVATE)
    }

    fun getUsername(): String? {
        return sharedPref.getString(username, "")
    }

    fun updateUsername(name: String) {
        val editor = sharedPref.edit()
        editor.putString(username, name)
        editor.apply()
        return
    }
}