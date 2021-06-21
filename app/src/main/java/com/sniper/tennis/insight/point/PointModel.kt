package com.sniper.tennis.insight.point

import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel
import com.sniper.tennis.insight.database.MyAppDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PointModel (private val myAppDatabase: MyAppDatabase) {

    suspend fun savePointProperties(dataModel: GeneralAnalysisDataModel) {
        myAppDatabase.getGeneralAnalysisPointDao().createPoint(dataModel)
    }
}