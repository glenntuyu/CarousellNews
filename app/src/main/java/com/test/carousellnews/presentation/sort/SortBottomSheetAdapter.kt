package com.test.carousellnews.presentation.sort

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.carousellnews.util.Constant

/**
 * Created by glenntuyu on 26/06/2024.
 */
class SortBottomSheetAdapter(
    private val sortBottomSheetListener: SortBottomSheetListener,
) : RecyclerView.Adapter<SortItemViewHolder>() {

    private var currentSort: String = ""

    private val sortList = listOf(
        Constant.RECENT,
        Constant.POPULAR,
    )

    fun setCurrentSort(sort: String) {
        this.currentSort = sort
    }

    override fun onBindViewHolder(holder: SortItemViewHolder, position: Int) {
        holder.bind(sortList[position], currentSort)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortItemViewHolder {
        return SortItemViewHolder.create(parent, sortBottomSheetListener)
    }

    override fun getItemCount(): Int {
        return sortList.size
    }
}