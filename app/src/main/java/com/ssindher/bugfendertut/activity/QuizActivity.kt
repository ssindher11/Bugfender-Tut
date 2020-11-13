package com.ssindher.bugfendertut.activity

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bugfender.sdk.Bugfender
import com.ssindher.bugfendertut.R
import com.ssindher.bugfendertut.utils.Constants
import kotlinx.android.synthetic.main.activity_quiz.*
import org.json.JSONObject

class QuizActivity : AppCompatActivity() {

    private var ans1 = ""
    private val ans2 = arrayListOf<String>()
    private var ans3 = ""
    private var ans4 = ""
    private var ans5 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        setupUI()
    }

    private fun setupUI() {
        rg1.setOnCheckedChangeListener { _, i ->
            Bugfender.d(Constants.BUGF_Q_NUM, "1")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_SCQ)
            when(i) {
                R.id.rb1 -> ans1 = rb1.text.toString()
                R.id.rb2 -> ans1 = rb2.text.toString()
                R.id.rb3 -> ans1 = rb3.text.toString()
                R.id.rb4 -> ans1 = rb4.text.toString()
            }
            Bugfender.d(Constants.BUGF_ANSWER, ans1)
        }

        mcb1.setOnCheckedChangeListener { mcb, b ->
            Bugfender.d(Constants.BUGF_Q_NUM, "2")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_MCQ)
            if (b) {
                ans2.add(mcb.text.toString())
            } else {
                ans2.remove(mcb.text.toString())
            }
        }

        mcb2.setOnCheckedChangeListener { mcb, b ->
            Bugfender.d(Constants.BUGF_Q_NUM, "2")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_MCQ)
            if (b) {
                ans2.add(mcb.text.toString())
            } else {
                ans2.remove(mcb.text.toString())
            }
        }

        mcb3.setOnCheckedChangeListener { mcb, b ->
            Bugfender.d(Constants.BUGF_Q_NUM, "2")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_MCQ)
            if (b) {
                ans2.add(mcb.text.toString())
            } else {
                ans2.remove(mcb.text.toString())
            }
        }

        mcb4.setOnCheckedChangeListener { mcb, b ->
            Bugfender.d(Constants.BUGF_Q_NUM, "2")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_MCQ)
            if (b) {
                ans2.add(mcb.text.toString())
            } else {
                ans2.remove(mcb.text.toString())
            }
        }

        rg2.setOnCheckedChangeListener { _, i ->
            Bugfender.d(Constants.BUGF_Q_NUM, "3")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_SCQ)
            when(i) {
                R.id.rb5 -> ans3 = rb5.text.toString()
                R.id.rb6 -> ans3 = rb6.text.toString()
                R.id.rb7 -> ans3 = rb7.text.toString()
                R.id.rb8 -> ans3 = rb8.text.toString()
            }
            Bugfender.d(Constants.BUGF_ANSWER, ans3)
        }

        rg3.setOnCheckedChangeListener { _, i ->
            Bugfender.d(Constants.BUGF_Q_NUM, "4")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_SCQ)
            when(i) {
                R.id.rb9 -> ans4 = rb9.text.toString()
                R.id.rb10 -> ans4 = rb10.text.toString()
                R.id.rb11 -> ans4 = rb11.text.toString()
                R.id.rb12 -> ans4 = rb12.text.toString()
            }
            Bugfender.d(Constants.BUGF_ANSWER, ans4)
        }

        rg4.setOnCheckedChangeListener { _, i ->
            Bugfender.d(Constants.BUGF_Q_NUM, "5")
            Bugfender.d(Constants.BUGF_Q_TYPE, Constants.BUGF_SCQ)
            when(i) {
                R.id.rb13 -> ans5 = rb13.text.toString()
                R.id.rb14 -> ans5 = rb14.text.toString()
                R.id.rb15 -> ans5 = rb15.text.toString()
                R.id.rb16 -> ans5 = rb16.text.toString()
            }
            Bugfender.d(Constants.BUGF_ANSWER, ans5)
        }

        btnSubmit.setOnClickListener {
            showAnimation()

            val json = JSONObject()
            json.put("A1", ans1)
            json.put("A2", ans2)
            json.put("A3", ans3)
            json.put("A4", ans4)
            json.put("A5", ans5)
            Log.d("myJSON", json.toString())
            Bugfender.d(Constants.BUGF_FINAL, json.toString())
        }
    }

    private fun showAnimation() {
        lavConfetti.visibility = View.VISIBLE
        lavConfetti.playAnimation()
        lavConfetti.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}
        })
    }
}