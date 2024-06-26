package com.test.carousellnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by glenntuyu on 26/06/2024.
 */
data class NewsResponseModel(
    @SerializedName("id")
    val id: String = "",

    @SerializedName("title")
    val title: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("banner_url")
    val bannerUrl: String = "",

    @SerializedName("time_created")
    val timeCreated: Long? = null,

    @SerializedName("rank")
    val rank: Int? = null,
)