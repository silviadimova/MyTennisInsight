package com.sniper.tennis.insight.point

import com.sniper.tennis.insight.R
import com.sniper.tennis.insight.dataModels.GeneralAnalysisDataModel
import com.sniper.tennis.insight.dataModels.isAnyPropertySelected
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class PointPresenterTest {

    private lateinit var tested: PointPresenter
    @RelaxedMockK
    private lateinit var view: PointPresenter.View
    @RelaxedMockK
    private lateinit var model: PointModel
    @RelaxedMockK
    private lateinit var dataModel: GeneralAnalysisDataModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        tested = PointPresenter(view, model)
    }

    @Test
    fun `should hide error and show loader when submit data`() {
        //given
        every { dataModel.isAnyPropertySelected() }.returns(true)
        //when
        tested.onSubmitDataModel(dataModel)
        //then
        verify { view.hideError() }
        verify { view.showLoader() }
    }

    @Test
    fun `should show error message`() {
        //given
        every { dataModel.isAnyPropertySelected() }.returns(false)
        //when
        tested.onSubmitDataModel(dataModel)
        //then
        verify { view.showError(R.string.point_error_message) }
    }
}