package com.sniper.tennis.insight.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.sniper.tennis.insight.R

class HomeActivity: AppCompatActivity(), HomePresenter.View {

    private val presenter = HomePresenter(this, HomeModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_layout)
        val matchesButton = findViewById<AppCompatButton>(R.id.home_matches_button)
        matchesButton.setOnClickListener {
            presenter.displayMatches()

        }
    }

    override fun navigateTo(target: Class<*>) {
        val matchesActivityIntent = Intent(this,target)
        startActivity(matchesActivityIntent)
    }
}