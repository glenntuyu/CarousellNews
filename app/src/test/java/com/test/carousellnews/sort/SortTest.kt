package com.test.carousellnews.sort

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.carousellnews.presentation.sort.SortBottomSheetViewModel
import com.test.carousellnews.util.Constant
import com.test.carousellnews.utils.shouldBe
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by glenntuyu on 26/06/2024.
 */
class SortTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var sortBottomSheetViewModel: SortBottomSheetViewModel

    @Before
    fun setUp() {
        sortBottomSheetViewModel = SortBottomSheetViewModel()
    }

    @Test
    fun `Test sort by Recent`() {
        `When view call getSortType`(Constant.RECENT)
        `Then assert sortType is recent`()
    }

    private fun `When view call getSortType`(type: String) {
        sortBottomSheetViewModel.setSortType(type)
    }

    private fun `Then assert sortType is recent`() {
        val data = sortBottomSheetViewModel.sortLiveData.value!!
        data shouldBe Constant.RECENT
    }

    @Test
    fun `Test sort by Popular`() {
        `When view call getSortType`(Constant.POPULAR)
        `Then assert sortType is popular`()
    }

    private fun `Then assert sortType is popular`() {
        val data = sortBottomSheetViewModel.sortLiveData.value!!
        data shouldBe Constant.POPULAR
    }
}