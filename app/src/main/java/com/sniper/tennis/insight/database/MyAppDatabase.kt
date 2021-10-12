package com.sniper.tennis.insight.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel
import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.dataModels.SetDataModel

@Database(
    entities = arrayOf(
        GeneralAnalysisDataModel::class,
        MatchDataModel::class,
        SetDataModel::class
    ),
    exportSchema = false,
    version = 1
)
abstract class MyAppDatabase: RoomDatabase() {

    companion object{
        private var myAppDatabaseInstance: MyAppDatabase? = null

        fun getInstance(context: Context): MyAppDatabase {
            if (myAppDatabaseInstance == null) {
                myAppDatabaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    MyAppDatabase::class.java,
                    "InsightTennisDatabase"
                ).fallbackToDestructiveMigration().build()
            }

            return myAppDatabaseInstance!!
        }
    }

    abstract fun getGeneralAnalysisPointDao(): GeneralAnalysisPointDao

    abstract fun getMatchDao(): MatchDao

    abstract fun getSetDao(): SetDao

}
