package com.sniper.tennis.insight.matches

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sniper.tennis.insight.R

class MatchesActivity: AppCompatActivity(), MatchesPresenter.View {

    private val presenter = MatchesPresenter(this, MatchesModel())
    private val matchesAdapter: MatchesAdapter = MatchesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matches_activity_layout)
        val matchesRecyclerView: RecyclerView = findViewById<RecyclerView>(R.id.matches_recycler_view)
        matchesRecyclerView.adapter = matchesAdapter
        matchesRecyclerView.isScrollbarFadingEnabled = false

        //presenter.readPreference()
        val matchesList: List<String> = mutableListOf<String>("Match1","Match2","Match3","Match4","Match5","Match6")
        matchesAdapter.submitList(matchesList)
    }

    override fun displayCache(cachedMatch: String) {


    }

}