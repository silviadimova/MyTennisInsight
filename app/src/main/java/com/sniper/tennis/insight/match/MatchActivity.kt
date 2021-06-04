package com.sniper.tennis.insight.match

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.sniper.tennis.insight.R

class MatchActivity: AppCompatActivity(), MatchPresenter.View {

    private val presenter = MatchPresenter(this, MatchModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_activity_layout)
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
            Toast.makeText(this,R.string.resume_match, Toast.LENGTH_LONG).show()
        }
        bottomSheetButton2.setOnClickListener {
            Toast.makeText(this,R.string.finish_match, Toast.LENGTH_LONG).show()
        }

    }

}