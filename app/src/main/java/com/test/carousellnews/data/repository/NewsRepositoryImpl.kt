package com.test.carousellnews.data.repository

import com.test.carousellnews.data.datasource.CarousellService
import com.test.carousellnews.data.model.NewsResponseModel
import com.test.carousellnews.util.Constant

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsRepositoryImpl(
    private val carousellService: CarousellService,
): NewsRepository {
    override suspend fun getNews(param: String): List<NewsResponseModel> {
        val list = carousellService.getNews()

        return if (param == Constant.POPULAR) {
            list.sortedBy { it.rank }
        } else {
            list.sortedWith(
                compareBy(
                    {it.rank}, {it.timeCreated}
                )
            )
        }
    }
}