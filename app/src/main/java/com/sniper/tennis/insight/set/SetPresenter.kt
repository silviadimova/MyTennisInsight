package com.sniper.tennis.insight.set

import com.sniper.tennis.insight.dataModels.NO_SET_ID
import com.sniper.tennis.insight.point.PointActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SetPresenter (
        private val view: View,
        private val model: SetModel,
        private var setID: Int = NO_SET_ID
) {
    fun onStartPointClick() {
        view.navigateTo(PointActivity::class.java,setID)
    }

    fun onEndSetClick() {
        view.displayEndSetDialog()
    }

    fun onSetEndConfirm() {
        //Todo replace the usage of GlobalScope with custom scope
        GlobalScope.launch(Dispatchers.IO) {
            model.updateSetToFinished(setID)
            withContext(Dispatchers.Main){
                view.finishScreen()
            }
        }
    }

    interface View{
        fun navigateTo(target: Class<*>,setID: Int)
        fun displayEndSetDialog()
        fun finishScreen()

    }
}