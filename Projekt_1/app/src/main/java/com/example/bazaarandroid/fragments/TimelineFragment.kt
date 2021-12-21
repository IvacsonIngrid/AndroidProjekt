package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaarandroid.R
import com.example.bazaarandroid.adapters.DataAdapter
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bazaarandroid.model.Product
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.bazaarandroid.utils.Constants.PAGE

class TimelineFragment : Fragment(), DataAdapter.OnItemClickListener, DataAdapter.OnItemLongClickListener {
    lateinit var listViewModel: TimelineViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: DataAdapter
    //private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TimelineViewModelFactory(Repository())
        listViewModel = ViewModelProvider(this, factory).get(TimelineViewModel::class.java)

        PAGE = "timeline"
        //Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_timeline, container, false)

        //viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        recycler_view = view.findViewById(R.id.recycler_view)
        setupRecyclerView()
        listViewModel.products.observe(viewLifecycleOwner){
            adapter.setData(listViewModel.products.value as ArrayList<Product>)
            adapter.notifyDataSetChanged()
        }

        return view
    }

    private fun setupRecyclerView(){
        adapter = DataAdapter(ArrayList<Product>(), this.requireContext(), this, this)

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
//        TODO("Not yet implemented")
    }

    override fun onItemClick(position: Int) {
//        TODO("Not yet implemented")
    }

    /*override fun onItemClick(position: Int) {
        //viewModel.currentPosition = position
        //findNavController().navigate(R.id.action_timelineFragment_to_settingsOthersFragment)
        Log.d("xxx", "AdapterPosition: $position")
    }*/
}