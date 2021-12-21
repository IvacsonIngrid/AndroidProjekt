package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.viewmodels.LoginViewModel
import com.example.bazaarandroid.viewmodels.LoginViewModelFactory
import com.example.bazaarandroid.viewmodels.RegisterViewModel
import com.example.bazaarandroid.viewmodels.RegisterViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xxx", "Elindultunk regisztralni:")
        val factory = RegisterViewModelFactory(this.requireContext(), Repository())
        Log.d("xxx", "factory megvan:")
        registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
        Log.d("xxx", "provider megvan:")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("xxx", "folytatom createview:")
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_register, container, false)
        Log.d("xxx", "layout megvan:")
        //innen//

        val edit_name: TextInputEditText = layout.findViewById(R.id.textInputEdit_name)
        Log.d("xxx", "fullname megvan: ${edit_name.text.toString()}")
        val edit_lastName: TextInputEditText = layout.findViewById(R.id.textInputEdit_lastname)
        Log.d("xxx", "lastname megvan: ${edit_lastName.text.toString()}")
        val edit_email: TextInputEditText = layout.findViewById(R.id.textInputEdit_email)
        Log.d("xxx", "email megvan: ${edit_email.text.toString()}")
        val edit_password: TextInputEditText = layout.findViewById(R.id.textInputEdit_password)
        Log.d("xxx", "password megvan: ${edit_password.text.toString()}")
        val edit_phoneNumber: TextInputEditText = layout.findViewById(R.id.textInputEdit_phone_number)
        Log.d("xxx", "phone number megvan: ${edit_phoneNumber.text.toString()}")

        val button: Button = layout.findViewById(R.id.button_register)
        Log.d("xxx", "megvan a GOMB")
        button.setOnClickListener {
            Log.d("xxx", "benne vagyok a listener-ben")
            registerViewModel.user.value.let {
                if (it != null) {
                    it.username = edit_name.text.toString()
                    Log.d("xxx", "Name -> String:")
                }
                if (it != null) {
                    it.password = edit_password.text.toString()
                    Log.d("xxx", "Password -> String:")
                }
                if (it != null) {
                    it.email = edit_email.text.toString()
                    Log.d("xxx", "Email -> String:")
                }
                if (it != null) {
                    it.phone_number = edit_phoneNumber.text.toString().toLong()
                    Log.d("xxx", "Password -> String:")
                }
            }
            lifecycleScope.launch {
                registerViewModel.register()
                Log.d("xxx", "Meg volt a REGISTER:")
                Toast.makeText(context,"Registration was successful!", Toast.LENGTH_SHORT).show()
            }

        }
        //eddig//

        /*val buttonRegister: Button = layout.findViewById(R.id.button_register)
        buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_timelineFragment)
        }*/

        val buttonLogin: TextView = layout.findViewById(R.id.textView_clickH2)
        buttonLogin.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return layout
    }
}