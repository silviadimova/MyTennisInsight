package com.sniper.tennis.insight.point

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel

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
        val unforcedErrorsButton: AppCompatButton = findViewById(R.id.unforcedErrorButton)
        val forcedErrorsButton: AppCompatButton = findViewById(R.id.forcedErrorButton)
        val opponentErrorButton: AppCompatButton = findViewById(R.id.opponentErrorButton)
        val volleyButton: AppCompatButton = findViewById(R.id.volleyButton)
        val winnerButton: AppCompatButton = findViewById(R.id.winner_button)
        val saveButton: AppCompatButton = findViewById(R.id.save_button)


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
        unforcedErrorsButton.setOnClickListener {
            twoButtonsToggle(unforcedErrorsButton,forcedErrorsButton)
        }

        forcedErrorsButton.setOnClickListener {
            twoButtonsToggle(forcedErrorsButton,unforcedErrorsButton)

        }
        opponentErrorButton.setOnClickListener {
            twoButtonsToggle(opponentErrorButton, winnerButton)

        }
        volleyButton.setOnClickListener {
            volleyButton.isSelected = !volleyButton.isSelected

        }
        winnerButton.setOnClickListener {
            twoButtonsToggle(winnerButton, opponentErrorButton)

        }
        saveButton.setOnClickListener {
            val dataModel: GeneralAnalysisDataModel = GeneralAnalysisDataModel(
                    successfulReturn = successfulReturnButton.isSelected,
                    unsuccessfulReturn = unsuccessfulReturnButton.isSelected,
                    firstServe = firstServeButton.isSelected,
                    secondServe = secondServeButton.isSelected,
                    doubleFault = doubleFaultButton.isSelected,
                    unforcedError = unforcedErrorsButton.isSelected,
                    forcedError = forcedErrorsButton.isSelected,
                    opponentError = opponentErrorButton.isSelected,
                    volley = volleyButton.isSelected,
                    winner = winnerButton.isSelected
            )
            presenter.onSubmitDataModel(dataModel)

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

    override fun hideError() {
        findViewById<AppCompatTextView>(R.id.point_error).visibility = View.GONE
    }

    override fun showError(message: Int) {
        val errorMessage: AppCompatTextView = findViewById(R.id.point_error)
        errorMessage.setText(message)
        errorMessage.visibility = View.VISIBLE
    }
}