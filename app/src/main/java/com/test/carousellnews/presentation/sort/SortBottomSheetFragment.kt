package com.test.carousellnews.presentation.sort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.carousellnews.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.carousellnews.databinding.FragmentSortBottomSheetBinding
import com.test.carousellnews.util.Constant
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by glenntuyu on 26/06/2024.
 */
@AndroidEntryPoint
class SortBottomSheetFragment: BottomSheetDialogFragment(), SortBottomSheetListener {

    private var viewBinding: FragmentSortBottomSheetBinding? = null

    private var currentSort = Constant.RECENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sort_bottom_sheet, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleArgs()
        initRecyclerView()
    }

    private fun handleArgs() {
        val safeArgs: SortBottomSheetFragmentArgs by navArgs()
        currentSort = safeArgs.currentSort
    }

    private fun initRecyclerView() {
        viewBinding?.sortBottomSheetRecyclerView?.let { rv ->
            val adapter = SortBottomSheetAdapter(this)
            adapter.setCurrentSort(currentSort)

            rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rv.adapter = adapter

            val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            rv.addItemDecoration(decoration)
        }
    }

    override fun onItemClick(sort: String) {
        val action = SortBottomSheetFragmentDirections.moveToNews(sort)
        findNavController().navigate(action)
    }
}