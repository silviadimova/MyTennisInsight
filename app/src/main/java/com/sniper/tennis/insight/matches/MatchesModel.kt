package com.sniper.tennis.insight.matches

import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.database.MyAppDatabase

class MatchesModel (private val myAppDatabase: MyAppDatabase) {

    suspend fun getAllMatches() : MutableList<MatchDataModel> {
        return myAppDatabase.getMatchDao().readAllMatches()
    }

    suspend fun deleteMatch(matchDataModel: MatchDataModel): Int{
       return myAppDatabase.getMatchDao().deleteMatch(matchDataModel)
    }



}