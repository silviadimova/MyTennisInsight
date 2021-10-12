package com.sniper.tennis.insight.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sniper.tennis.insight.dataModels.MATCH_TABLE
import com.sniper.tennis.insight.dataModels.MatchDataModel

@Dao
interface MatchDao {

    @Insert
    suspend fun createMatch(matchDataModel: MatchDataModel): Long

    @Query("UPDATE $MATCH_TABLE SET isFinished=true WHERE id=:theMatchId")
    suspend fun finishMatch(theMatchId: Long)

    @Query("UPDATE $MATCH_TABLE SET isFinished=true WHERE id=:theSetId")
    suspend fun finishSet(theSetId: Int)

    @Query("SELECT * FROM $MATCH_TABLE")
    suspend fun readAllMatches() :MutableList<MatchDataModel>

    @Delete
    suspend fun deleteMatch(matchDataModel: MatchDataModel): Int


}