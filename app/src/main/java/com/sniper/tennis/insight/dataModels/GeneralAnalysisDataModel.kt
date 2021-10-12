package com.sniper.tennis.insight.dataModels

import androidx.room.Entity
import androidx.room.PrimaryKey

const val GENERAL_ANALYSIS_TABLE_NAME = "GeneralAnalysis"

@Entity(tableName = GENERAL_ANALYSIS_TABLE_NAME)
data class GeneralAnalysisDataModel(
    val setID: Int,
    val matchID: Int,
    val successfulReturn: Boolean,
    val unsuccessfulReturn: Boolean,
    val firstServe: Boolean,
    val secondServe: Boolean,
    val doubleFault: Boolean,
    val unforcedError: Boolean,
    val forcedError: Boolean,
    val opponentError: Boolean,
    val volley: Boolean,
    val winner: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

fun GeneralAnalysisDataModel.isAnyPropertySelected(): Boolean {
    return unsuccessfulReturn
            || successfulReturn
            || firstServe
            || secondServe
            || doubleFault
            || unforcedError
            || forcedError
            || opponentError
            || volley
            || winner
}
