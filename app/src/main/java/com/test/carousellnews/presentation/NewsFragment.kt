package com.test.carousellnews.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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

        handleArgs()
        observeViewModel()
        prepareView()
        getNews()
    }

    private fun handleArgs() {
        val safeArgs: NewsFragmentArgs by navArgs()
        viewModel.currentSort = safeArgs.sort
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
        initMenu()
        initRecyclerView()
        initSwipeRefreshLayout()
    }

    private fun initMenu() {
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.sort_menu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.sort_dest -> {
                        val action = NewsFragmentDirections.moveToSort(viewModel.currentSort)
                        findNavController().navigate(action)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner)
    }

    private fun initRecyclerView() {
        viewBinding?.newsRecyclerView?.let { rv ->
            adapter = NewsAdapter()
            rv.addItemDecoration(NewsCardItemDecoration(requireContext(), R.dimen.dp_8))
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
        viewModel.getInitialNews(viewModel.currentSort)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sort_menu, menu)
    }

}