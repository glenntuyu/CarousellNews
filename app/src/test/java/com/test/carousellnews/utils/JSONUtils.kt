package com.test.carousellnews.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

/**
 * Created by glenntuyu on 26/06/2024.
 */
inline fun <reified T> String.jsonToObject(): T {
    val systemClassLoader = ClassLoader.getSystemClassLoader()
    val urlResource = systemClassLoader.getResource(this)
    val urlResourcePath = urlResource.path
    val fileFromUrlResourcePath = File(urlResourcePath)
    val jsonString = String(fileFromUrlResourcePath.readBytes())

    val type: Type = object : TypeToken<T>() {}.type
    return Gson().fromJson(jsonString, type)
}