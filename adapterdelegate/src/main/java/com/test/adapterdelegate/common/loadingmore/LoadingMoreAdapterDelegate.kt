package com.test.adapterdelegate.common.loadingmore

import android.view.ViewGroup
import com.test.adapterdelegate.databinding.LoadingItemLayoutBinding
import com.test.adapterdelegate.TypedAdapterDelegate

/**
 * Created by glenntuyu on 26/06/2024.
 */
class LoadingMoreAdapterDelegate :
    TypedAdapterDelegate<LoadingMoreDataView, Any, LoadingMoreViewHolder, LoadingItemLayoutBinding>(
        LoadingMoreViewHolder.LAYOUT
    ) {

    override fun onBindViewHolder(item: LoadingMoreDataView, holder: LoadingMoreViewHolder) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        binding: LoadingItemLayoutBinding
    ): LoadingMoreViewHolder {
        return LoadingMoreViewHolder(binding)
    }
}