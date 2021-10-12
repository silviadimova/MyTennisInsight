package com.sniper.tennis.insight.matches

import com.sniper.tennis.insight.dataModels.MatchDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchesPresenter (
        private val view: View,
        private val model: MatchesModel
) {

    private lateinit var matchesList: MutableList<MatchDataModel>

    fun onMatchesListRead() {
        //Todo replace the usage of GlobalScope with custom scope
        GlobalScope.launch(Dispatchers.IO){
            matchesList = model.getAllMatches()
            withContext(Dispatchers.Main){
                when {
                    matchesList.isEmpty() -> view.displayNoMatches()
                    else ->  view.displayMatchesList(matchesList)
                }

            }
        }
    }

    fun onMatchClickDelete(
            matchDataModel: MatchDataModel,
            position: Int
    ) {
        //Todo replace the usage of GlobalScope with custom scope
        GlobalScope.launch(Dispatchers.IO) {
            val deletedMatchNumber: Int = model.deleteMatch(matchDataModel)
            withContext(Dispatchers.Main) {
                when (deletedMatchNumber) {
                    0 -> view.displayError()
                    else -> {
                        matchesList.removeAt(position)
                        view.removeMatch(position)
                        if(matchesList.isEmpty()){
                            view.displayNoMatches()
                        }
                    }
                }
            }

        }

    }

    interface View {
        fun displayMatchesList(matchesList: List<MatchDataModel>)
        fun removeMatch(position: Int)
        fun displayError()
        fun displayNoMatches()

    }
}