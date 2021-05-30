package com.sniper.tennis.insight.match

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class MatchActivity: AppCompatActivity(), MatchPresenter.View {

    private val presenter = MatchPresenter(this, MatchModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_activity_layout)
    }

}