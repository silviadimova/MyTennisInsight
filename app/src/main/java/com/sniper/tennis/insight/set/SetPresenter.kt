package com.sniper.tennis.insight.set

import com.sniper.tennis.insight.point.PointActivity

class SetPresenter (private val view: View, private val model: SetModel) {
    fun onStartPointClick() {
        view.navigateTo(PointActivity::class.java)
    }

    fun onEndSetClick() {
        view.displayEndSetDialog()
    }

    interface View{
        fun navigateTo(target: Class<*>)
        fun displayEndSetDialog()

    }
}