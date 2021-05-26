package com.sniper.tennis.insight.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class HomeActivity: AppCompatActivity(), HomePresenter.View {

    private val presenter = HomePresenter(this, HomeModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_layout)
    }
}