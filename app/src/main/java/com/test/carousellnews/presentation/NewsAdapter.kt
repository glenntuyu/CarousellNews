package com.test.carousellnews.presentation

import com.test.adapterdelegate.BaseCommonAdapter
import com.test.carousellnews.presentation.view.NewsCardAdapterDelegate

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsAdapter() : BaseCommonAdapter() {

    init {
        delegatesManager
            .addDelegate(NewsCardAdapterDelegate())
    }

    fun updateList(newList: List<Any>) {
        setItemsAndAnimateChanges(newList)
    }
}