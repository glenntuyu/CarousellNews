package com.test.carousellnews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.adapterdelegate.common.error.ErrorDataView
import com.test.carousellnews.data.model.NewsResponseModel
import com.test.carousellnews.domain.GetNewsUseCase
import com.test.carousellnews.util.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by glenntuyu on 26/06/2024.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
): ViewModel() {

    private val listData = mutableListOf<Any>()

    private val listMutableLiveData = MutableLiveData<List<Any>>()
    val listLiveData: LiveData<List<Any>>
        get() = listMutableLiveData

    private val isRefreshingMutableLiveData = MutableLiveData(false)
    val isRefreshingLiveData: LiveData<Boolean> = isRefreshingMutableLiveData

    fun getNews() {
        getNewsUseCase.execute(
            ::onGetNewsSuccess,
            ::onGetNewsFailed,
            1
        )
    }

    private fun onGetNewsSuccess(list: List<NewsResponseModel>) {
        handleData(list)
        updateIsRefreshing(false)
        updateListLiveData()
    }

    private fun handleData(list: List<NewsResponseModel>) {
        if (list.isEmpty()) showEmptyState()
        else addNewsToListData(list)
    }

    private fun showEmptyState() {
        listData.add(ErrorDataView(Constant.NO_DATA))
    }

    private fun addNewsToListData(list: List<NewsResponseModel>) {
        listData.addAll(list.toListNewsCardDataView())
    }

    private fun updateIsRefreshing(isRefreshing: Boolean) {
        isRefreshingMutableLiveData.postValue(isRefreshing)
    }

    private fun updateListLiveData() {
        listMutableLiveData.value = listData
    }

    private fun onGetNewsFailed(throwable: Throwable) {
        clearListData()
        updateIsRefreshing(false)
        setErrorNetwork()

        updateListLiveData()
    }

    private fun setErrorNetwork() {
        listData.add(ErrorDataView(Constant.ERROR_NETWORK))
    }

    fun refreshNews() {
        resetState()
        updateListLiveData()
        updateIsRefreshing(true)
        getNews()
    }

    private fun resetState() {
        clearListData()
    }

    private fun clearListData() {
        listData.clear()
    }

}