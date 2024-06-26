package com.test.carousellnews.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.test.carousellnews.R
import com.test.carousellnews.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var viewBinding: FragmentNewsBinding? = null
    private val viewModel: NewsViewModel by viewModels()

    private var adapter: NewsAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        prepareView()
        getNews()
    }

    private fun observeViewModel() {
        viewModel.listLiveData.observe(this::submitList)
        viewModel.isRefreshingLiveData.observe(this::updateIsRefreshing)
    }

    private fun <T> LiveData<T>.observe(observer: Observer<in T>) {
        observe(viewLifecycleOwner, observer)
    }

    private fun submitList(list: List<Any>?) {
        list?.let {
            adapter?.updateList(it)
        }
    }

    private fun updateIsRefreshing(isLoadingVisible: Boolean) {
        viewBinding?.newsSwipeRefreshLayout?.isRefreshing = isLoadingVisible
    }

    private fun prepareView() {
        initRecyclerView()
        initSwipeRefreshLayout()
    }

    private fun initRecyclerView() {
        viewBinding?.newsRecyclerView?.let { rv ->
            adapter = NewsAdapter()
            rv.adapter = adapter
        }
    }

    private fun initSwipeRefreshLayout() {
        viewBinding?.newsSwipeRefreshLayout?.let {
            it.isVerticalScrollBarEnabled = true
            it.setOnRefreshListener {
                refreshView()
            }
        }
    }

    private fun refreshView() {
        viewModel.refreshNews()
    }

    private fun getNews() {
        viewModel.getNews()
    }

}