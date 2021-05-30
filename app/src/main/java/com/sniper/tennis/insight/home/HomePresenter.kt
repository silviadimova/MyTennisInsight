package com.sniper.tennis.insight.home

import com.sniper.tennis.insight.matches.MatchesActivity

class HomePresenter (private val view: View, private val model: HomeModel){
    fun displayMatches() {
        view.navigateTo(MatchesActivity::class.java)
    }

    interface View{
        fun navigateTo(target :Class<*>)

    }
}