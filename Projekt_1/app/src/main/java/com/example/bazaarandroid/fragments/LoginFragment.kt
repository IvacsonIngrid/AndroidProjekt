package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bazaarandroid.R
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.viewmodels.LoginViewModel
import com.example.bazaarandroid.viewmodels.LoginViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import com.example.bazaarandroid.utils.Constants.USER_NAME

class LoginFragment : Fragment() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xxx", "Elindultunk:")
        val factory = LoginViewModelFactory(this.requireContext(), Repository())
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_login, container, false)
        Log.d("xxx", "Tovabb:")

        val editText1: TextInputEditText = layout.findViewById(R.id.textInputEdit_name)
        Log.d("xxx", "name:  $editText1")

        val editText2: TextInputEditText = layout.findViewById(R.id.textInputEdit_password)
        Log.d("xxx", "name:  $editText2")

        val button: Button = layout.findViewById(R.id.button_login)
        button.setOnClickListener {
            loginViewModel.user.value.let {
                if (it != null) {
                    it.username = editText1.text.toString()
                    Log.d("xxx", "Name -> String:")

                    //eltarolom, hogy ki lepett be
                    USER_NAME = editText1.text.toString()
                }
                if (it != null) {
                    it.password = editText2.text.toString()
                    Log.d("xxx", "Password -> String:")
                }
            }
            lifecycleScope.launch {
                loginViewModel.login()
                Log.d("xxx", "Meg volt a LOGIN:")
            }

        }

        loginViewModel.token.observe(viewLifecycleOwner){
            Log.d("xxx", "navigate to timeline")
            findNavController().navigate(R.id.action_loginFragment_to_timelineFragment)
        }

        val buttonSignUp: Button = layout.findViewById(R.id.button_signup)
        buttonSignUp.setOnClickListener{
            Log.d("xxx", "navigate to register")
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        /*val buttonPassword: TextView = layout.findViewById(R.id.textView_clickH)
        buttonPassword.setOnClickListener{
            Log.d("xxx", "navigate to forgot password")
            findNavController().navigate(R.id.action_loginFragment_to_passwordFragment)
        }*/

        return layout
    }
}