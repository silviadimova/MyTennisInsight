package com.sniper.tennis.insight.matches

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sniper.tennis.insight.R

class MatchesAdapter (private val matchesActivity: MatchesActivity): ListAdapter<String,MatchesViewHolder>(MatchesDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val inflatedLayout = View.inflate(parent.context, R.layout.matches_match_item, null)
        return MatchesViewHolder(inflatedLayout,matchesActivity)
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val match = getItem(position)
        holder.bindData(match)
    }

}


class MatchesViewHolder(private val mainView: View, private val matchesActivity: MatchesActivity): RecyclerView.ViewHolder(mainView){
    fun bindData (match: String){
        val myFirstMatch = mainView.findViewById<AppCompatTextView>(R.id.match)
        myFirstMatch.text = match

    }
}

class MatchesDiffUtil : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}