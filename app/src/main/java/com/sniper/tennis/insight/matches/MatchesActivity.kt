package com.sniper.tennis.insight.matches

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class MatchesActivity: AppCompatActivity(), MatchesPresenter.View {

    private val presenter = MatchesPresenter(this, MatchesModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matches_activity_layout)
    }

}