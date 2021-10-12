package com.sniper.tennis.insight.match

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.MatchDataModel
import com.sniper.tennis.insight.database.MyAppDatabase

const val MATCH_ID_EXTRA = "MatchIdExtra"

class MatchActivity: AppCompatActivity(), MatchPresenter.View {

    private lateinit var presenter: MatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_activity_layout)
        presenter = MatchPresenter(this, MatchModel(MyAppDatabase.getInstance(this)))
        MatchTypeDialogFragment()
                .setDialogListener(::onMatchTypeSelected)
                .show(supportFragmentManager,MATCH_TYPE_DIALOG_TAG)

        val bottomSheetButton1: AppCompatButton = findViewById(R.id.bottom_sheet_button1)
        bottomSheetButton1.text = getString(R.string.start_set)
        val bottomSheetButton2: AppCompatButton = findViewById(R.id.bottom_sheet_button2)
        bottomSheetButton2.text = getString(R.string.end_match)
        val bottomSheetParent = findViewById<ConstraintLayout>(R.id.bottom_sheet_parent)

        val bottomSheetBehavior: BottomSheetBehavior<View> = BottomSheetBehavior.from(bottomSheetParent)
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState){
                    BottomSheetBehavior.STATE_COLLAPSED -> findViewById<ImageView>(R.id.bottom_sheet_indicator).setImageResource(R.drawable.ic_expand)
                    BottomSheetBehavior.STATE_EXPANDED -> findViewById<ImageView>(R.id.bottom_sheet_indicator).setImageResource(R.drawable.ic_collapse)
                    else -> { }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetParent.setOnClickListener {
            when (bottomSheetBehavior.state){
                BottomSheetBehavior.STATE_COLLAPSED -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                else -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }


        }
        bottomSheetButton1.setOnClickListener {
            presenter.onStartSetClick()
        }
        bottomSheetButton2.setOnClickListener {
            presenter.onEndMatchClick()

        }

    }

    override fun navigateTo(target: Class<*>, matchId: Long) {
        val targetIntent: Intent = Intent(this,target)
        targetIntent.putExtra(MATCH_ID_EXTRA, matchId.toInt())
        startActivity(targetIntent)
    }

    override fun displayEndMatchDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(R.string.finish_match).setCancelable(false)
        alertDialog.setPositiveButton(R.string.yes_button, object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                presenter.onMatchEndConfirm()
                dialog?.dismiss()
            }

        })
        alertDialog.setNegativeButton(R.string.no_button, object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
            }

        })

        alertDialog.show()
    }

    override fun finishScreen() {
        finish()
    }

    private fun onMatchTypeSelected(selectedMatchType: Int) {
        val dataModel: MatchDataModel = MatchDataModel(selectedMatchType,false)
        presenter.onSubmitDataModel(dataModel)
    }

}