package com.sniper.tennis.insight.dataModels

import androidx.room.Entity
import androidx.room.PrimaryKey

const val GENERAL_ANALYSIS_TYPE = 1
const val FOREHAND_ANALYSIS_TYPE = 2
const val BACKHAND_ANALYSIS_TYPE = 3
const val SERVE_ANALYSIS_TYPE = 4
const val RETURN_ANALYSIS_TYPE = 5
const val VOLLEY_ANALYSIS_TYPE = 6
const val MATCH_TABLE = "Match"

@Entity(tableName = MATCH_TABLE)
data class MatchDataModel(
        val matchId: Int,
        val matchType: Int

){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

}
