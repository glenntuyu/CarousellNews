package com.test.carousellnews.presentation.sort

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.test.carousellnews.R
import com.test.carousellnews.databinding.SortItemViewHolderBinding
import com.test.carousellnews.util.Constant

/**
 * Created by glenntuyu on 26/06/2024.
 */
class SortItemViewHolder(
    private val binding: SortItemViewHolderBinding,
    private val sortBottomSheetListener: SortBottomSheetListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(sort: String, currentSort: String) {
        bindListener(sort)
        bindText(sort, currentSort)
    }

    private fun bindText(text: String, currentSort: String) {
       val currentType = getCurrentType(currentSort)
        binding.sortItemText.text = text
        setTextColor(text, currentType)
    }

    private fun getCurrentType(currentSort: String): String {
        return when(currentSort) {
            Constant.RECENT -> Constant.RECENT
            Constant.POPULAR -> Constant.POPULAR
            else -> ""
        }
    }

    private fun setTextColor(text: String, currentType: String) {
        if (text == currentType) {
            binding.sortItemText.setTextColor(ContextCompat.getColor(binding.root.context, R.color.red_2))
            binding.sortItemLayout.isEnabled = false
        }
    }

    private fun bindListener(sort: String) {
        binding.sortItemLayout.setOnClickListener {
            sortBottomSheetListener.onItemClick(sort)
        }
    }

    companion object {
        fun create(parent: ViewGroup, sortBottomSheetListener: SortBottomSheetListener,): SortItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.sort_item_view_holder, parent, false)
            val binding = SortItemViewHolderBinding.bind(view)
            return SortItemViewHolder(binding, sortBottomSheetListener)
        }
    }
}