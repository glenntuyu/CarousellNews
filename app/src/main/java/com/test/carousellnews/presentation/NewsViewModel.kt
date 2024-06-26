package com.test.carousellnews.presentation

import androidx.lifecycle.ViewModel
import com.test.carousellnews.domain.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by glenntuyu on 26/06/2024.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
): ViewModel() {

}