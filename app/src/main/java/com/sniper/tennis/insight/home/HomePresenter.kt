package com.sniper.tennis.insight.home

import com.sniper.tennis.insight.match.MatchActivity
import com.sniper.tennis.insight.matches.MatchesActivity

class HomePresenter (private val view: View, private val model: HomeModel){
    fun onMatchesClick() {
        view.navigateTo(MatchesActivity::class.java)
    }

    fun onMatchClick() {
        view.navigateTo(MatchActivity::class.java)
    }

    interface View{
        fun navigateTo(target :Class<*>)

    }
}