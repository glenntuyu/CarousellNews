package com.test.adapterdelegate.common.loadingpage

import android.view.ViewGroup
import com.test.adapterdelegate.TypedAdapterDelegate
import com.test.adapterdelegate.databinding.LoadingPageLayoutBinding

/**
 * Created by glenntuyu on 26/06/2024.
 */
class LoadingPageAdapterDelegate :
    TypedAdapterDelegate<LoadingPageDataView, Any, LoadingPageViewHolder, LoadingPageLayoutBinding>(
        LoadingPageViewHolder.LAYOUT
    ) {

    override fun onBindViewHolder(item: LoadingPageDataView, holder: LoadingPageViewHolder) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        binding: LoadingPageLayoutBinding
    ): LoadingPageViewHolder {
        return LoadingPageViewHolder(binding)
    }
}