package com.sniper.tennis.insight.match

import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.dataModels.NO_MATCH_ID
import com.sniper.tennis.insight.set.SetActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchPresenter (
        private val view: View,
        private val model: MatchModel,
        private var matchId: Long = NO_MATCH_ID
) {

    fun onStartSetClick() {
        view.navigateTo(SetActivity::class.java, matchId)
    }

    fun onEndMatchClick() {
        view.displayEndMatchDialog()
    }

    fun onMatchEndConfirm() {
        //Todo replace the usage of GlobalScope with custom scope
        GlobalScope.launch(Dispatchers.IO) {
            model.updateMatchToFinished(matchId)
            withContext(Dispatchers.Main) {
                view.finishScreen()
            }
        }
    }

    fun onSubmitDataModel(dataModel: MatchDataModel) {
        //Todo replace the usage of GlobalScope with custom scope
        GlobalScope.launch(Dispatchers.IO) {
            matchId = model.createMatch(dataModel)

        }
    }



    interface View{
        fun finishScreen()
        fun navigateTo(target: Class<*>, matchID: Long)
        fun displayEndMatchDialog()
    }
}