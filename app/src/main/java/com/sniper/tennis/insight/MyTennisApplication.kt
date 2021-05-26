package com.sniper.tennis.insight

import android.app.Application

class MyTennisApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}