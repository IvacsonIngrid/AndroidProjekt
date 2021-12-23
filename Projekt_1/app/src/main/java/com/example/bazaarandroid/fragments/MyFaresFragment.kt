package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaarandroid.R
import com.example.bazaarandroid.adapters.DataAdapter
import com.example.bazaarandroid.adapters.DataAdapter2
import com.example.bazaarandroid.model.Orders
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.PAGE
import com.example.bazaarandroid.viewmodels.MyFaresViewModel
import com.example.bazaarandroid.viewmodels.MyFaresViewModelFactory
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory

class MyFaresFragment : Fragment(), DataAdapter2.OnItemClickListener, DataAdapter2.OnItemLongClickListener{
    lateinit var listViewModel: MyFaresViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: DataAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = MyFaresViewModelFactory(Repository())
        listViewModel = ViewModelProvider(this, factory).get(MyFaresViewModel::class.java)

        PAGE = "sales"
        Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_my_fares, container, false)

        recycler_view = view.findViewById(R.id.recycler_view_orders)
        setupRecyclerView()
        listViewModel.orders.observe(viewLifecycleOwner){
            adapter.setData(listViewModel.orders.value as ArrayList<Orders>)
            adapter.notifyDataSetChanged()
        }

        return view
    }

    private fun setupRecyclerView(){
        adapter = DataAdapter2(ArrayList<Orders>(), this.requireContext(), this, this)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemLongClick(position: Int) {
        //
    }

    override fun onItemClick(position: Int) {
        //
    }
}