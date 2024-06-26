package com.test.carousellnews.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.adapterdelegate.common.error.ErrorDataView
import com.test.carousellnews.data.model.NewsResponseModel
import com.test.carousellnews.domain.GetNewsUseCase
import com.test.carousellnews.presentation.NewsViewModel
import com.test.carousellnews.presentation.view.NewsCardDataView
import com.test.carousellnews.util.Constant
import com.test.carousellnews.util.toTimeAgo
import com.test.carousellnews.utils.jsonToObject
import com.test.carousellnews.utils.listShouldBe
import com.test.carousellnews.utils.shouldBe
import com.test.carousellnews.utils.shouldBeInstanceOf
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var newsViewModel: NewsViewModel
    private val getNewsUseCase = mockk<GetNewsUseCase>(relaxed = true)

    private val newsCommonResponse = "news.json"
    private val mockkNews: List<NewsResponseModel> = newsCommonResponse.jsonToObject()
    private val newsPopularResponse = "news_popular.json"
    private val mockkNewsPopular: List<NewsResponseModel> = newsPopularResponse.jsonToObject()

    private val sortSlot = slot<String>()

    @Before
    fun setUp() {
        newsViewModel = createViewModel()
    }

    private fun createViewModel(): NewsViewModel {
        return NewsViewModel(
            getNewsUseCase,
        )
    }

    @Test
    fun `Test Get News Success`() {
        val mockkList = mockkNews
        `Given getNewsUseCase will return List NewsResponseModel`(mockkList)
        `When view call getNews`()
        `Then assert sort param`(Constant.RECENT)
        `Then assert news list`(mockkList)
    }

    private fun `Given getNewsUseCase will return List NewsResponseModel`(
        list: List<NewsResponseModel>,
    ) {
        every { getNewsUseCase.execute(any(), any(), capture(sortSlot)) }.answers {
            firstArg<(List<NewsResponseModel>) -> Unit>().invoke(list)
        }
    }

    private fun `When view call getNews`(sort: String = Constant.RECENT) {
        newsViewModel.getNews(sort)
    }

    private fun `Then assert sort param`(sort: String) {
        val capturedSlot = sortSlot.captured

        capturedSlot shouldBe sort
    }

    private fun `Then assert news list`(list: List<NewsResponseModel>) {
        val data = newsViewModel.listLiveData.value!!

        data.shouldBeInstanceOf<List<NewsCardDataView>>()

        data.filterIsInstance<NewsCardDataView>().listShouldBe(list) { actual, expected ->
            actual.id shouldBe expected.id
            actual.title shouldBe expected.title
            actual.description shouldBe expected.description
            actual.bannerUrl shouldBe expected.bannerUrl
            actual.timeCreated shouldBe expected.timeCreated
            actual.timeCreatedString shouldBe expected.timeCreated.toTimeAgo()
            actual.rank shouldBe expected.rank
        }
    }

    @Test
    fun `Test Get News Sort by Popular Success`() {
        val mockkList = mockkNewsPopular
        `Given getNewsUseCase will return List NewsResponseModel`(mockkList)
        `When view call getNews`(Constant.POPULAR)
        `Then assert sort param`(Constant.POPULAR)
        `Then assert news list`(mockkList)
    }

    @Test
    fun `Test Get Favorite User List Failed`() {
        `Given getNewsUseCase will return error`()
        `When view call getNews`()
        `Then assert error`()
    }

    private fun `Given getNewsUseCase will return error`() {
        every { getNewsUseCase.execute(any(), any(), any()) }.answers {
            secondArg<(Throwable) -> Unit>().invoke(Throwable(Constant.ERROR_NETWORK))
        }
    }

    private fun `Then assert error`() {
        val data = newsViewModel.listLiveData.value!!

        data.size shouldBe 1
        data[0].shouldBeInstanceOf<ErrorDataView>()
        (data[0] as ErrorDataView).title shouldBe Constant.ERROR_NETWORK
    }

    @Test
    fun `Test Get Favorite User List Empty`() {
        `Given getNewsUseCase will return empty list`()
        `When view call getNews`()
        `Then assert empty`()
    }

    private fun `Given getNewsUseCase will return empty list`() {
        every { getNewsUseCase.execute(any(), any(), any()) }.answers {
            firstArg<(List<NewsResponseModel>) -> Unit>().invoke(listOf())
        }
    }

    private fun `Then assert empty`() {
        val data = newsViewModel.listLiveData.value!!

        data.size shouldBe 1
        data[0].shouldBeInstanceOf<ErrorDataView>()
        (data[0] as ErrorDataView).title shouldBe Constant.NO_DATA
    }

}