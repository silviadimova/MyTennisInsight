package com.sniper.tennis.insight.set

import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.database.MyAppDatabase

class SetModel (private val myAppDatabase: MyAppDatabase){


    suspend fun updateSetToFinished(setId: Int) {
        myAppDatabase.getMatchDao().finishSet(setId)

    }
}