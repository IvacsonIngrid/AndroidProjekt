package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R
import com.google.android.material.textfield.TextInputEditText

class PasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var layout = inflater.inflate(R.layout.fragment_password, container, false)

        val editText1: TextInputEditText = layout.findViewById(R.id.textInputEdit_email)

        val buttonSignUp: Button = layout.findViewById(R.id.button_send_email)
        buttonSignUp.setOnClickListener{
            Toast.makeText(context,"We sent it to the email you provided: ${editText1.text.toString()}", Toast.LENGTH_SHORT).show()
        }

        return layout
    }
}