package com.sniper.tennis.insight

import android.app.Application
import com.facebook.stetho.Stetho

class MyTennisApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}