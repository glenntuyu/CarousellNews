package com.test.carousellnews.presentation

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by glenntuyu on 26/06/2024.
 */
class NewsCardItemDecoration(
    context: Context,
    @DimenRes marginInDp: Int,
) : RecyclerView.ItemDecoration() {

    private val marginInPx: Int =
        context.resources.getDimension(marginInDp).toInt()

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        if (isFirstItem(view, parent)) outRect.top = marginInPx
        else outRect.top = marginInPx / 2

        if (isLastItem(view, parent)) outRect.bottom = marginInPx
        else outRect.bottom = marginInPx / 2

        outRect.left = marginInPx
        outRect.right = marginInPx
    }

    private fun isFirstItem(view: View, parent: RecyclerView) =
        parent.getChildAdapterPosition(view) == 0

    private fun isLastItem(view: View, parent: RecyclerView) =
        parent.getChildAdapterPosition(view) == (parent.adapter?.itemCount ?: 0) - 1

}