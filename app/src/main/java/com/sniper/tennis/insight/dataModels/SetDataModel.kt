package com.sniper.tennis.insight.dataModels

import androidx.room.Entity
import androidx.room.PrimaryKey

const val SET_TABLE = "Set"

@Entity(tableName = SET_TABLE)
data class SetDataModel(
    val isFinished: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

}
