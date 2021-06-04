package com.sniper.tennis.insight.matches

class MatchesPresenter (private val view: View, private val model: MatchesModel) {
    fun readPreference() {
      view.displayCache(model.savedMatch)
    }

    interface View{
        fun displayCache(cachedMatch: String)

    }
}