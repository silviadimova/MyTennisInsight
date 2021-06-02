package com.sniper.tennis.insight.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.sniper.tennis.insight.R

class HomeActivity: AppCompatActivity(), HomePresenter.View {

    private val presenter: HomePresenter = HomePresenter(this, HomeModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_layout)
        findViewById<AppCompatButton>(R.id.home_matches_button).setOnClickListener {
            presenter.onMatchesClick()
        }
        findViewById<AppCompatButton>(R.id.home_start_button).setOnClickListener {
            presenter.onMatchClick()
        }
    }

    override fun navigateTo(target: Class<*>) {
        val targetIntent: Intent = Intent(this,target)
        startActivity(targetIntent)

    }
}