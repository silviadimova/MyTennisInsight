package com.sniper.tennis.insight.set

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sniper.tennis.insight.R

class SetActivity: AppCompatActivity(), SetPresenter.View {

    private val presenter = SetPresenter(this, SetModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_activity_layout)
    }

}