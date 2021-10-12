package com.sniper.tennis.insight.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.BACKHAND_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.FOREHAND_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.GENERAL_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.RETURN_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.SERVE_ANALYSIS_TYPE
import com.sniper.tennis.insight.dataModels.VOLLEY_ANALYSIS_TYPE

const val MATCH_TYPE_DIALOG_TAG = "MatchTypeDialogFragment"

class MatchTypeDialogFragment: DialogFragment() {
    private lateinit var temp: (selectedType: Int) -> Unit
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_dialog_match_type, container, false)
        isCancelable = false
        view.findViewById<AppCompatButton>(R.id.general_analysis_button).setOnClickListener {
            temp(GENERAL_ANALYSIS_TYPE)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.forehand_analysis_button).setOnClickListener {
            temp(FOREHAND_ANALYSIS_TYPE)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.backhand_analysis_button).setOnClickListener {
            temp(BACKHAND_ANALYSIS_TYPE)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.serve_analysis_button).setOnClickListener {
            temp(SERVE_ANALYSIS_TYPE)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.return_analysis_button).setOnClickListener {
            temp(RETURN_ANALYSIS_TYPE)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.volley_analysis_button).setOnClickListener {
            temp(VOLLEY_ANALYSIS_TYPE)
            dismiss()
        }

        return view
    }

    fun setDialogListener(callback: (selectedType: Int) -> Unit): MatchTypeDialogFragment {
        temp = callback
        return this
    }


}