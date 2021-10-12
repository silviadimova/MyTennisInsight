package com.sniper.tennis.insight.point

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel
import com.sniper.tennis.insight.database.MyAppDatabase
import com.sniper.tennis.insight.match.MATCH_ID_EXTRA
import com.sniper.tennis.insight.set.SET_ID_EXTRA

class PointActivity: AppCompatActivity(), PointPresenter.View {

    private lateinit var presenter: PointPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.point_activity_layout)

        presenter = PointPresenter(this, PointModel(MyAppDatabase.getInstance(this)))

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
                setID = intent.getIntExtra(SET_ID_EXTRA,0),
                matchID = intent.getIntExtra(MATCH_ID_EXTRA, 0),
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

    override fun showLoader() {
        findViewById<FrameLayout>(R.id.progressBar).visibility = View.VISIBLE
    }

    override fun hideLoader() {
        findViewById<FrameLayout>(R.id.progressBar).visibility = View.GONE
    }

    override fun closePoint() {
        finish()
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