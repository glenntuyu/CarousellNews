package com.test.carousellnews.presentation.view

/**
 * Created by glenntuyu on 26/06/2024.
 */
data class NewsCardDataView(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val bannerUrl: String = "",
    val timeCreated: Long? = null,
    val timeCreatedString: String = "",
    val rank: Int? = null,
)