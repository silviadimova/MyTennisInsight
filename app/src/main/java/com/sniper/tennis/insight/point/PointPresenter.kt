package com.sniper.tennis.insight.point

import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel

class PointPresenter (private val view: View, private val model: PointModel) {

    fun onSubmitDataModel(dataModel: GeneralAnalysisDataModel) {
        if(dataModel.unsuccessfulReturn==false && dataModel.successfulReturn==false && dataModel.firstServe==false && dataModel.secondServe ==false && dataModel.doubleFault==false && dataModel.unforcedError==false && dataModel.forcedError==false && dataModel.opponentError==false && dataModel.volley==false && dataModel.winner==false){
            view.showError(R.string.point_error_message)
        }else{
            view.hideError()
            model.savePointProperties(dataModel)
        }

    }

    interface View{
        fun showError(message: Int)
        fun hideError()

    }
}