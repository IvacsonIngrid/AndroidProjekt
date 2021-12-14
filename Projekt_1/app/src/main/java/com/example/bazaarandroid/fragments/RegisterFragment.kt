package com.example.bazaarandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_register, container, false)

        val buttonRegister: Button = layout.findViewById(R.id.button_register)
        buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_timelineFragment)
        }

        val buttonLogin: TextView = layout.findViewById(R.id.textView_clickH2)
        buttonLogin.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return layout
    }
}