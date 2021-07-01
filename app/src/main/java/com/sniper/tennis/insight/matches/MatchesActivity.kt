package com.sniper.tennis.insight.matches

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.database.MyAppDatabase

class MatchesActivity: AppCompatActivity(), MatchesPresenter.View {

    private val matchesAdapter: MatchesAdapter = MatchesAdapter(this)
    private lateinit var presenter: MatchesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matches_activity_layout)
        presenter = MatchesPresenter(this, MatchesModel(MyAppDatabase.getInstance(this)))

        val matchesRecyclerView: RecyclerView = findViewById<RecyclerView>(R.id.matches_recycler_view)
        matchesRecyclerView.adapter = matchesAdapter
        matchesRecyclerView.isScrollbarFadingEnabled = false
        presenter.onMatchesListRead()
    }
    override fun displayMatchesList(matchesList: List<MatchDataModel>) {
        matchesAdapter.submitList(matchesList)
    }
    fun onSelectedMatchDelete(matchDataModel: MatchDataModel,position: Int){
        presenter.onMatchClickDelete(matchDataModel,position)
     }

    override fun removeMatch(position: Int) {
        matchesAdapter.notifyItemRemoved(position)
    }

    override fun displayError() {
        Toast.makeText(this,R.string.match_delete_error, Toast.LENGTH_LONG).show()
    }

    override fun displayNoMatches() {
        val text = findViewById<AppCompatTextView>(R.id.no_matches_text)
        text.visibility = View.VISIBLE


    }


}