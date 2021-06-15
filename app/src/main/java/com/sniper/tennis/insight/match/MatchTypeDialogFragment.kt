package com.sniper.tennis.insight.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import com.sniper.tennis.insight.R

const val MATCH_TYPE_DIALOG_TAG = "MatchTypeDialogFragment"

class MatchTypeDialogFragment: DialogFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_dialog_match_type, container, false)
        isCancelable = false
        view.findViewById<AppCompatButton>(R.id.general_analysis_button).setOnClickListener {
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.forehand_analysis_button).setOnClickListener {
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.backhand_analysis_button).setOnClickListener {
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.serve_analysis_button).setOnClickListener {
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.return_analysis_button).setOnClickListener {
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.volley_analysis_button).setOnClickListener {
            dismiss()
        }

        return view
    }


}