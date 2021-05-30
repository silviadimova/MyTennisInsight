package com.sniper.tennis.insight.point

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class PointActivity: AppCompatActivity(), PointPresenter.View {

    private val presenter = PointPresenter(this, PointModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.point_activity_layout)
    }

}