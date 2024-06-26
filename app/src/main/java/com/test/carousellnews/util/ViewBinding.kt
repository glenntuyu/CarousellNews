package com.test.carousellnews.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * Created by glenntuyu on 26/06/2024.
 */
object ViewBinding {
    @BindingAdapter("android:showTextIfNotEmpty")
    @JvmStatic
    fun showTextIfNotEmpty(textView: TextView, text: String?) {
        textView.setTextAndCheckShow(text)
    }

    @BindingAdapter("app:shouldShowView")
    @JvmStatic
    fun shouldShowView(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @BindingAdapter(
        value = ["glideUrl", "glideCornerRadius"],
        requireAll = false
    )
    @JvmStatic
    fun bindImageUrl(
        view: ImageView,
        url: String?,
        radius: Int?,
    ) {
        if (!url.isNullOrEmpty()) {
            val glide = Glide.with(view.context)
                .load(url)

            radius?.let {
                glide.transform(MultiTransformation(CenterCrop(), RoundedCorners(radius)))
            }

            glide.into(view)
        }
    }
}