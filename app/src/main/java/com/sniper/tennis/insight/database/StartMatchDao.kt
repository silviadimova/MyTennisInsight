package com.sniper.tennis.insight.database

import androidx.room.Dao
import androidx.room.Insert
import com.sniper.tennis.insight.dataModels.MatchDataModel

@Dao
interface StartMatchDao {

    @Insert
    suspend fun startMatch(matchDataModel: MatchDataModel)

}