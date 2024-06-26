package com.test.carousellnews.data.datasource

import com.test.carousellnews.data.model.NewsResponseModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by glenntuyu on 26/06/2024.
 */
interface CarousellService {
    @GET("carousell_news.json")
    suspend fun getNews(): List<NewsResponseModel>

    companion object {
        private const val BASE_URL = "https://storage.googleapis.com/carousell-interview-assets/android/"

        fun create(): CarousellService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CarousellService::class.java)
        }
    }
}