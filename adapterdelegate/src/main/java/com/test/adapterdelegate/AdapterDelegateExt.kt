package com.test.adapterdelegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Created by glenntuyu on 26/06/2024.
 */
fun <T> AdapterDelegate<T>.getView(parent: ViewGroup, @LayoutRes layoutRes: Int): View = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)