package com.sniper.tennis.insight.set

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.database.MyAppDatabase
import com.sniper.tennis.insight.match.MATCH_ID_EXTRA

const val SET_ID_EXTRA = "SetIdExtra"
class SetActivity: AppCompatActivity(), SetPresenter.View {

    private val presenter = SetPresenter(this, SetModel(MyAppDatabase.getInstance(this)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_activity_layout)
        val bottomSheetButton1: AppCompatButton = findViewById(R.id.bottom_sheet_button1)
        bottomSheetButton1.text = getString(R.string.start_point)
        val bottomSheetButton2: AppCompatButton = findViewById(R.id.bottom_sheet_button2)
        bottomSheetButton2.text = getString(R.string.end_set)
        val bottomSheetParent = findViewById<ConstraintLayout>(R.id.bottom_sheet_parent)
        val bottomSheetBehavior: BottomSheetBehavior<View> = BottomSheetBehavior.from(bottomSheetParent)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState){
                    BottomSheetBehavior.STATE_COLLAPSED -> findViewById<ImageView>(R.id.bottom_sheet_indicator).setImageResource(R.drawable.ic_expand)
                    BottomSheetBehavior.STATE_EXPANDED -> findViewById<ImageView>(R.id.bottom_sheet_indicator).setImageResource(R.drawable.ic_collapse)
                    else -> { }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //no implementation
            }
        })
        bottomSheetParent.setOnClickListener {
            when (bottomSheetBehavior.state){
                BottomSheetBehavior.STATE_COLLAPSED -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                else -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }


        }
        bottomSheetButton1.setOnClickListener {
            presenter.onStartPointClick()
        }
        bottomSheetButton2.setOnClickListener {
            presenter.onEndSetClick()
        }
    }

    override fun displayEndSetDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(R.string.want_end_set).setCancelable(false)
        alertDialog.setPositiveButton(R.string.yes_button, object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                presenter.onSetEndConfirm()
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

    override fun navigateTo(target: Class<*>, setID: Int) {
        val targetIntent = Intent(this,target)
        val matchId = intent.getIntExtra(MATCH_ID_EXTRA,0)
        targetIntent.putExtra(MATCH_ID_EXTRA, matchId)
        targetIntent.putExtra(SET_ID_EXTRA,setID)
        startActivity(targetIntent)
    }

    override fun finishScreen(){
        finish()
    }

}