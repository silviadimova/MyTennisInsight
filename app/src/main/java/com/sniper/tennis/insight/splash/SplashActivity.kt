package com.sniper.tennis.insight.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class SplashActivity: AppCompatActivity(), SplashPresenter.View {

    private val presenter: SplashPresenter = SplashPresenter(this,SplashModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity_layout)
    }

}