package com.sniper.tennis.insight.point

import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel
import com.sniper.tennis.insight.dataModels.isAnyPropertySelected
import kotlinx.coroutines.*

class PointPresenter (private val view: View, private val model: PointModel) {

    fun onSubmitDataModel(dataModel: GeneralAnalysisDataModel) {
        if(dataModel.isAnyPropertySelected()){
            view.hideError()
            view.showLoader()
            GlobalScope.launch (Dispatchers.IO) {
                model.savePointProperties(dataModel)
                delay(500)
                withContext (Dispatchers.Main) {
                    view.hideLoader()
                    view.closePoint()
                }
            }
        }else{
            view.showError(R.string.point_error_message)
        }

    }

    interface View{
        fun showError(message: Int)
        fun hideError()
        fun showLoader()
        fun hideLoader()
        fun closePoint()

    }
}