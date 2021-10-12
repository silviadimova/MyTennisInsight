package com.sniper.tennis.insight.match

import com.sniper.tennis.insight.set.SetActivity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before

import org.junit.Test

class MatchPresenterTest {

    lateinit var tested :MatchPresenter
    @RelaxedMockK
    lateinit var view: MatchPresenter.View
    @RelaxedMockK
    lateinit var model: MatchModel
    var matchId: Long = 0

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        tested = MatchPresenter(view,model,matchId)
    }

    @Test
    fun `should navigate to set screen when start set click`(){
        tested.onStartSetClick()
        verify { view.navigateTo(SetActivity::class.java,matchId) }
    }
}