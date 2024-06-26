package com.test.adapterdelegate

import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by glenntuyu on 26/06/2024.
 */
open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun onViewRecycled() {}

    protected fun getString(@StringRes stringRes: Int): String {
        return itemView.context.getString(stringRes)
    }

    protected fun getString(@StringRes stringRes: Int, vararg value: Any): String {
        return itemView.context.getString(stringRes, *value)
    }
}