package com.sniper.tennis.insight.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class IntroActivity: AppCompatActivity(), IntroPresenter.View {

    private val presenter = IntroPresenter(this,IntroModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity_layout)
    }

}