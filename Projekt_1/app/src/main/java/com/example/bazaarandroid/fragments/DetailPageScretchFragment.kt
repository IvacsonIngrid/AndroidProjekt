package com.example.bazaarandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaarandroid.R
import com.example.bazaarandroid.adapters.DataAdapter
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory

class DetailPageScretchFragment : Fragment() {
    lateinit var listViewModel: TimelineViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TimelineViewModelFactory(Repository())
        listViewModel = ViewModelProvider(this, factory).get(TimelineViewModel::class.java)

        Constants.PAGE = "detailProductAdd"
        //Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_detail_page_scretch, container, false)



        return layout
    }
}