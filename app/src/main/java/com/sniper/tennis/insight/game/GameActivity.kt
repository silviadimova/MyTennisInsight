package com.sniper.tennis.insight.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class GameActivity: AppCompatActivity(), GamePresenter.View {

    private val presenter = GamePresenter(this, GameModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity_layout)
    }

}