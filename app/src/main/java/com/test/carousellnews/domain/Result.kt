package com.test.carousellnews.domain

/**
 * Created by glenntuyu on 26/06/2024.
 */
sealed class Result<out T: Any>
data class Success<out T: Any>(val data: T): Result<T>()
data class Fail(val throwable: Throwable): Result<Nothing>()