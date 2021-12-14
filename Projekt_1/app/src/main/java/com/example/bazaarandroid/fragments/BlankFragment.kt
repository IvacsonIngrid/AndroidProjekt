package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R

class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_blank, container, false)


        /*val buttonPassword: TextView = view.findViewById(R.id.textView_seller_item_layout)
        buttonPassword.setOnClickListener{
            Log.d("xxx", "navigate to forgot password")
            findNavController().navigate(R.id.action_timelineFragment_to_settingsOthersFragment)
        }*/

        return view
    }
}