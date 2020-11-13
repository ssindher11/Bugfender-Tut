package com.ssindher.bugfendertut.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bugfender.sdk.a.a.l.a.i
import com.ssindher.bugfendertut.R
import kotlinx.android.synthetic.main.activity_crash.*
import kotlinx.android.synthetic.main.activity_main.*

class CrashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash)

        setupUI()
    }

    private fun setupUI() {
        btnCrash1.setOnClickListener { println(1 / 0) }

        btnCrash2.setOnClickListener {
            val i: Int? = null
            println((i as Int) + 4)
        }

        btnCrash3.setOnClickListener { textView.text = "" }

        btnCrash4.setOnClickListener {
            val list = listOf(1, 2, 3, 4, 5)
            list[5]
        }
    }
}