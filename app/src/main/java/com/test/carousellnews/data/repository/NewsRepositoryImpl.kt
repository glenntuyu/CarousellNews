package com.test.carousellnews.data.repository

import com.test.carousellnews.data.datasource.CarousellService
import com.test.carousellnews.data.model.NewsResponseModel

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsRepositoryImpl(
    private val carousellService: CarousellService,
): NewsRepository {
    override suspend fun getNews(page: Int): List<NewsResponseModel> {
        return carousellService.getNews()
    }
}