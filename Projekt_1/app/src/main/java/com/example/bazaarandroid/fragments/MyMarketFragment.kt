package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaarandroid.R
import com.example.bazaarandroid.adapters.DataAdapter
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants.PAGE
import com.example.bazaarandroid.viewmodels.MyMarketViewModel
import com.example.bazaarandroid.viewmodels.MyMarketViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyMarketFragment : Fragment(), DataAdapter.OnItemClickListener, DataAdapter.OnItemLongClickListener {
    lateinit var listViewModel: MyMarketViewModel
    private lateinit var recycler_view_my: RecyclerView
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = MyMarketViewModelFactory(Repository())
        listViewModel = ViewModelProvider(this, factory).get(MyMarketViewModel::class.java)

        PAGE = "mymarket"
        //Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_my_market, container, false)

        recycler_view_my = view.findViewById(R.id.recycler_view2)
        setupRecyclerView()
        listViewModel.products.observe(viewLifecycleOwner){
            adapter.setData(listViewModel.products.value as ArrayList<Product>)
            adapter.notifyDataSetChanged()
        }

        //most
        var button_add: FloatingActionButton = view.findViewById(R.id.button_add_product)
        button_add.setOnClickListener{
            Log.d("xxx", "navigate to add page")
            findNavController().navigate(R.id.action_myMarketFragment_to_detailPageScretchFragment)
        }
        //----------------
        return view
    }

    private fun setupRecyclerView(){
        adapter = DataAdapter(ArrayList<Product>(), this.requireContext(), this, this)

        recycler_view_my.adapter = adapter
        recycler_view_my.layoutManager = LinearLayoutManager(this.context)
        recycler_view_my.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler_view_my.setHasFixedSize(true)
    }

    override fun onItemLongClick(position: Int) {
//        TODO("Not yet implemented")
    }

    override fun onItemClick(position: Int) {
//        TODO("Not yet implemented")
    }
}