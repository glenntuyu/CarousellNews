package com.test.carousellnews.data.repository

import com.test.carousellnews.data.model.NewsResponseModel

/**
 * Created by glenntuyu on 26/06/2024.
 */
interface NewsRepository {
    suspend fun getNews(param: String): List<NewsResponseModel>
}