package com.sniper.tennis.insight.point

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.sniper.tennis.insight.R

class PointActivity: AppCompatActivity(), PointPresenter.View {

    private val presenter = PointPresenter(this, PointModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.point_activity_layout)

        val successfulReturnButton: AppCompatButton = findViewById(R.id.successfulReturnButton)
        val unsuccessfulReturnButton: AppCompatButton = findViewById(R.id.unSuccessfulReturnButton)
        val firstServeButton: AppCompatButton = findViewById(R.id.firstServeButton)
        val secondServeButton: AppCompatButton = findViewById(R.id.secondServeButton)
        val doubleFaultButton: AppCompatButton = findViewById(R.id.doubleFaultButton)

        successfulReturnButton.setOnClickListener {
            twoButtonsToggle(successfulReturnButton,unsuccessfulReturnButton)
        }
        unsuccessfulReturnButton.setOnClickListener {
            twoButtonsToggle(unsuccessfulReturnButton,successfulReturnButton)
        }
        firstServeButton.setOnClickListener {
           threeButtonsToggle(firstServeButton,secondServeButton,doubleFaultButton)
        }
        secondServeButton.setOnClickListener {
            threeButtonsToggle(secondServeButton,firstServeButton,doubleFaultButton)
        }
        doubleFaultButton.setOnClickListener {
            threeButtonsToggle(doubleFaultButton,firstServeButton,secondServeButton)
        }

    }
    private fun twoButtonsToggle(button1: AppCompatButton, button2: AppCompatButton){
        if (button1.isSelected) {
            button1.isSelected = false
        } else {
            button1.isSelected = true
            button2.isSelected = false
        }
    }
    private fun threeButtonsToggle(button1: AppCompatButton,button2: AppCompatButton,button3: AppCompatButton){
        if (button1.isSelected) {
            button1.isSelected = false
        } else {
            button1.isSelected = true
            button2.isSelected = false
            button3.isSelected = false
        }

    }
}