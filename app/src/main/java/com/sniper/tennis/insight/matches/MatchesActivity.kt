package com.sniper.tennis.insight.matches

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sniper.tennis.insight.R

class MatchesActivity: AppCompatActivity(), MatchesPresenter.View {

    private val presenter = MatchesPresenter(this, MatchesModel())
    private val matchesAdapter = MatchesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matches_activity_layout)
        val matchesActivityRecyclerView = findViewById<RecyclerView>(R.id.matches_recycler_view)
        matchesActivityRecyclerView.adapter = matchesAdapter
        matchesActivityRecyclerView.isScrollbarFadingEnabled = false
    }

}