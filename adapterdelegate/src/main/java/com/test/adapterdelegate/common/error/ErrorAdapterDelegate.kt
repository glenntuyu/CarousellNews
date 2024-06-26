package com.test.adapterdelegate.common.error

import android.view.ViewGroup
import com.test.adapterdelegate.databinding.ErrorPageLayoutBinding
import com.test.adapterdelegate.TypedAdapterDelegate

/**
 * Created by glenntuyu on 26/06/2024.
 */
class ErrorAdapterDelegate :
    TypedAdapterDelegate<ErrorDataView, Any, ErrorViewHolder, ErrorPageLayoutBinding>(
        ErrorViewHolder.LAYOUT
    ) {

    override fun onBindViewHolder(item: ErrorDataView, holder: ErrorViewHolder) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        binding: ErrorPageLayoutBinding
    ): ErrorViewHolder {
        return ErrorViewHolder(binding)
    }
}