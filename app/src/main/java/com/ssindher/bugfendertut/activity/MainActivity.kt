package com.ssindher.bugfendertut.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bugfender.sdk.Bugfender
import com.ssindher.bugfendertut.R
import com.ssindher.bugfendertut.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var loginID = ""
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)

        setupUI()
    }

    private fun setupUI() {
        if (prefs.contains(Constants.LOGIN_ID)) {
            loginID = prefs.getString(Constants.LOGIN_ID, "") ?: ""
            tvLoginId.text = loginID
        } else {
            generateLoginID()
        }

        btnNewId.setOnClickListener { generateLoginID() }

        btnStart.setOnClickListener {
            Bugfender.setDeviceString(Constants.LOGIN_ID, loginID)
            startActivity(Intent(this, QuizActivity::class.java))
        }

        btnCrash.setOnClickListener { startActivity(Intent(this, CrashActivity::class.java)) }
    }

    private fun generateLoginID() {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        loginID = (1..16).map { allowedChars.random() }.joinToString("")
        tvLoginId.text = loginID
        with(prefs.edit()) {
            putString(Constants.LOGIN_ID, loginID)
            apply()
        }
    }

}