package com.sniper.tennis.insight.database

import androidx.room.*
import com.sniper.tennis.insight.dataModels.GENERAL_ANALYSIS_TABLE_NAME
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel

@Dao
interface GeneralAnalysisPointDao {

    @Insert
    suspend fun createPoint(generalAnalysisDataModel: GeneralAnalysisDataModel)
    @Query("Select * from $GENERAL_ANALYSIS_TABLE_NAME")
    suspend fun readAllPoints(): List<GeneralAnalysisDataModel>
    @Update
    suspend fun updatePoint(generalAnalysisDataModel: GeneralAnalysisDataModel)
    @Delete
    suspend fun deletePoint(generalAnalysisDataModel: GeneralAnalysisDataModel)
}