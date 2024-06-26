package com.test.carousellnews.util

import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * Created by glenntuyu on 26/06/2024.
 */

fun Long?.toTimeAgo(): String {
    if (this == null) return ""

    val date = Date(TimeUnit.SECONDS.toMillis(this))

    return TimeAgo.getText(date) ?: ""
}