package com.sniper.tennis.insight.matches

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.BACKHAND_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.FOREHAND_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.GENERAL_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.dataModels.RETURN_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.SERVE_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.VOLLEY_ANALYSIS_TYPE

class MatchesAdapter (private val matchesActivity: MatchesActivity): ListAdapter<MatchDataModel,MatchesViewHolder>(MatchesDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val inflatedLayout = View.inflate(parent.context, R.layout.matches_match_item, null)
        return MatchesViewHolder(inflatedLayout,matchesActivity)
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val matchDataModel = getItem(position)
        holder.bindData(matchDataModel, position)
    }

}

class MatchesViewHolder(private val mainView: View, private val matchesActivity: MatchesActivity): RecyclerView.ViewHolder(mainView){

    fun bindData (matchDataModel: MatchDataModel, position: Int){
        val myMatch = mainView.findViewById<AppCompatTextView>(R.id.match)
        when(matchDataModel.matchType){
            GENERAL_ANALYSIS_TYPE -> myMatch.text = mainView.resources.getText(R.string.general_analysis)
            FOREHAND_ANALYSIS_TYPE -> myMatch.text = mainView.resources.getText(R.string.forehand_analysis)
            BACKHAND_ANALYSIS_TYPE-> myMatch.text = mainView.resources.getText(R.string.backhand_analysis)
            SERVE_ANALYSIS_TYPE-> myMatch.text = mainView.resources.getText(R.string.serve_analysis)
            RETURN_ANALYSIS_TYPE -> myMatch.text = mainView.resources.getText(R.string.return_analysis)
            VOLLEY_ANALYSIS_TYPE-> myMatch.text = mainView.resources.getText(R.string.volley_analysis)
        }
        mainView.findViewById<ImageView>(R.id.delete_icon).setOnClickListener {
            matchesActivity.onSelectedMatchDelete(matchDataModel,position)
        }
    }

}

class MatchesDiffUtil : DiffUtil.ItemCallback<MatchDataModel>(){
    override fun areItemsTheSame(oldItem: MatchDataModel, newItem: MatchDataModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MatchDataModel, newItem: MatchDataModel): Boolean {
        return oldItem == newItem
    }

}