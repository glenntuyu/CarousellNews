package com.test.carousellnews.util

import java.text.ParseException
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * Created by glenntuyu on 26/06/2024.
 */
object TimeAgo {
    fun getText(date: Date): String? {
        var elapsed: String? = null
        try {
            val dateDiff = System.currentTimeMillis() - date.time
            val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
            val day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)

            if (second < 60) {
                elapsed = "a few seconds ago"
            } else if (minute < 2) {
                elapsed = "a minute ago"
            } else if (minute < 60) {
                elapsed = "$minute minutes ago"
            } else if (hour < 2) {
                elapsed = "an hour ago"
            } else if (hour < 24) {
                elapsed = "$hour hours ago"
            } else if (day < 2) {
                elapsed = "a day ago"
            } else if (day < 25) {
                elapsed = "$day days ago"
            } else if (day < 45) {
                elapsed = "a month ago"
            } else if (day >= 45) {
                elapsed = if (day <= 300) { //10 months
                    if ((day / 30).toInt() == 1) "2 months ago"
                    else (day / 30).toString() + " months ago"
                } else if (day <= 510) { //17 months
                    "a year ago"
                } else {
                    (day / 360).toString() + " years ago"
                }
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return elapsed
    }
}