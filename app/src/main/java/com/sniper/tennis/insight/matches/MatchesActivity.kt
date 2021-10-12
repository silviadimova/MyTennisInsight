package com.sniper.tennis.insight.matches

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.database.MyAppDatabase
import com.sniper.tennis.insight.extensions.showToast

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
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(R.string.want_delete_match).setCancelable(false)
        alertDialog.setPositiveButton(R.string.yes_button,object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                presenter.onMatchClickDelete(matchDataModel,position)
            }
        })
        alertDialog.setNegativeButton(R.string.no_button,object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
            }
        })
        alertDialog.show()
     }

    override fun removeMatch(position: Int) {
        matchesAdapter.notifyItemRemoved(position)
    }

    override fun displayError() {
        showToast(R.string.match_delete_error)
    }

    override fun displayNoMatches() {
        val text = findViewById<AppCompatTextView>(R.id.no_matches_text)
        text.visibility = View.VISIBLE
    }

}