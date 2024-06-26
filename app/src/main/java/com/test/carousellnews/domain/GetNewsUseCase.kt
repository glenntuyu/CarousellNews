package com.test.carousellnews.domain

import com.test.carousellnews.data.model.NewsResponseModel
import com.test.carousellnews.data.repository.NewsRepository
import javax.inject.Inject

/**
 * Created by glenntuyu on 26/06/2024.
 */
class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository,
): UseCase<List<NewsResponseModel>, String>() {

    override suspend fun executeOnBackground(param: String): List<NewsResponseModel> {
        return repository.getNews(param)
    }
}