package com.test.carousellnews.presentation.view

import android.view.ViewGroup
import com.test.adapterdelegate.TypedAdapterDelegate
import com.test.carousellnews.databinding.NewsCardViewHolderBinding

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsCardAdapterDelegate(): TypedAdapterDelegate<NewsCardDataView, Any, NewsCardViewHolder, NewsCardViewHolderBinding>(
    NewsCardViewHolder.LAYOUT
) {

    override fun onBindViewHolder(item: NewsCardDataView, holder: NewsCardViewHolder) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        binding: NewsCardViewHolderBinding
    ): NewsCardViewHolder {
        return NewsCardViewHolder(binding)
    }
}