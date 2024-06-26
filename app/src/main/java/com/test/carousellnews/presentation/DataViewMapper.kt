package com.test.carousellnews.presentation

import com.test.carousellnews.data.model.NewsResponseModel
import com.test.carousellnews.presentation.view.NewsCardDataView
import com.test.carousellnews.util.toTimeAgo

/**
 * Created by glenntuyu on 26/06/2024.
 */
fun List<NewsResponseModel>.toListNewsCardDataView(): List<NewsCardDataView> {
    val list = mutableListOf<NewsCardDataView>()

    this.forEach {
       list.add(
           NewsCardDataView(
               id = it.id,
               title = it.title,
               description = it.description,
               bannerUrl = it.bannerUrl,
               timeCreated =  it.timeCreated,
               timeCreatedString = it.timeCreated.toTimeAgo(),
               rank = it.rank,
           )
       )
    }

    return list
}