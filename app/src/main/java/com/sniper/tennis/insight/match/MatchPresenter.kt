package com.sniper.tennis.insight.match

import com.sniper.tennis.insight.set.SetActivity

class MatchPresenter (private val view: View, private val model: MatchModel) {

    fun onStartSetClick() {
        view.navigateTo(SetActivity::class.java)
    }

    fun onEndMatchClick() {
        view.displayEndMatchDialog()
    }

    interface View{

        fun navigateTo(target: Class<*>)
        fun displayEndMatchDialog()

    }
}