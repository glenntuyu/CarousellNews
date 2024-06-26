package com.test.adapterdelegate.common.loadingmore

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.test.adapterdelegate.R
import com.test.adapterdelegate.databinding.LoadingItemLayoutBinding

/**
 * Created by glenntuyu on 26/06/2024.
 */
class LoadingMoreViewHolder(private val binding: LoadingItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: LoadingMoreDataView) {
        binding.data = data
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.loading_item_layout
    }
}