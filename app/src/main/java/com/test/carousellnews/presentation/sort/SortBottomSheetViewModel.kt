package com.test.carousellnews.presentation.sort

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by glenntuyu on 26/06/2024.
 */
@HiltViewModel
class SortBottomSheetViewModel @Inject constructor(): ViewModel() {
    private var currentSort = ""

    private val sortMutableLiveData = MutableLiveData<String>()
    val sortLiveData: LiveData<String>
        get() = sortMutableLiveData

    fun setSortType(sort: String) {
        sortMutableLiveData.value = sort
    }

    fun setCurrentSort(filter: String) {
        this.currentSort = filter
    }

    fun getCurrentSort(): String {
        return currentSort
    }
}