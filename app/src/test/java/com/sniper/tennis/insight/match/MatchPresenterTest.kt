package com.sniper.tennis.insight.match

import com.sniper.tennis.insight.set.SetActivity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before

import org.junit.Test

class MatchPresenterTest {

    private lateinit var tested: MatchPresenter
    @RelaxedMockK
    private lateinit var view: MatchPresenter.View
    @RelaxedMockK
    private lateinit var model: MatchModel
    private var matchId: Long = 0L

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        tested = MatchPresenter(view,model,matchId)
    }

    @Test
    fun `should navigate to set screen when start set click`() {
        //when
        tested.onStartSetClick()
        //then
        verify { view.navigateTo(SetActivity::class.java,matchId) }
    }

    @Test
    fun `should show end match dialog when match end click`() {
        //when
        tested.onEndMatchClick()
        //then
        verify { view.displayEndMatchDialog() }
    }

}