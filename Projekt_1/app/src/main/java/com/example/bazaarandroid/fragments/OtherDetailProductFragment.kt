package com.example.bazaarandroid.fragments

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.bazaarandroid.R
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory

class OtherDetailProductFragment : Fragment() {
    private lateinit var viewModel: TimelineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TimelineViewModelFactory(Repository())
        viewModel = ViewModelProvider(this, factory).get(TimelineViewModel::class.java)

        Constants.PAGE = "detail"
        //Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_other_detail_product, container, false)


        viewModel = ViewModelProvider(requireActivity()).get(TimelineViewModel::class.java)
        val item: Product = viewModel.getItem()

        val textView1: EditText = layout.findViewById(R.id.detail_text1)
        val textView2: EditText = layout.findViewById(R.id.detail_text2)

        Log.i("xxx", "leirasba: ${item.title}, ${item.username}")


        textView1.setText(item.title)
        textView2.setText(item.username)

        Log.d("xxx", "DetailFragment - onCreateView")
        return layout
    }
}