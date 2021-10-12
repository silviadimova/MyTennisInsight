package com.sniper.tennis.insight.home

import com.sniper.tennis.insight.match.MatchActivity
import com.sniper.tennis.insight.matches.MatchesActivity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class HomePresenterTest {

    private lateinit var tested: HomePresenter
    @RelaxedMockK
    private lateinit var view: HomePresenter.View
    @RelaxedMockK
    private lateinit var model: HomeModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        tested = HomePresenter(view, model)
    }

    @Test
    fun `should open matches screen when matches click`() {
        //when
        tested.onMatchesClick()
        //then
        verify { view.navigateTo(MatchesActivity::class.java) }
    }

    @Test
    fun `should open match screen when match click`() {
        //when
        tested.onMatchClick()
        //then
        verify { view.navigateTo(MatchActivity::class.java) }
    }

    @Test
    fun `should open match screen when tiebreak click`() {
        //when
        tested.onTiebreakClick()
        //then
        verify { view.navigateTo(MatchActivity::class.java) }
    }

}
