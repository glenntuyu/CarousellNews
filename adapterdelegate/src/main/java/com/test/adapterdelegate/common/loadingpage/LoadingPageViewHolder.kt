package com.test.adapterdelegate.common.loadingpage

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.test.adapterdelegate.R
import com.test.adapterdelegate.databinding.LoadingPageLayoutBinding

/**
 * Created by glenntuyu on 26/06/2024.
 */
class LoadingPageViewHolder(binding: LoadingPageLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.loading_page_layout
    }
}