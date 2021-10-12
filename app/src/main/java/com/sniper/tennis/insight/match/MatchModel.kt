package com.sniper.tennis.insight.match

import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.database.MyAppDatabase

class MatchModel(private val myAppDatabase: MyAppDatabase) {

    suspend fun createMatch(dataModel: MatchDataModel) : Long {
        return myAppDatabase.getMatchDao().createMatch(dataModel)
    }

    suspend fun updateMatchToFinished(matchId: Long){
        myAppDatabase.getMatchDao().finishMatch(matchId)
    }

}