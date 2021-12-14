package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R
import com.example.bazaarandroid.model.User

class SettingsOthersFragment : Fragment() {
    var user = MutableLiveData<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_settings_others, container, false)



        return layout
    }
}