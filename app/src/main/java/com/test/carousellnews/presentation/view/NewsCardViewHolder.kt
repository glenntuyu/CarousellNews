package com.test.carousellnews.presentation.view

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.test.carousellnews.R
import com.test.carousellnews.databinding.NewsCardViewHolderBinding

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsCardViewHolder(
    private val binding: NewsCardViewHolderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.news_card_view_holder
    }

    fun bind(data: NewsCardDataView) {
        binding.data = data
    }
}