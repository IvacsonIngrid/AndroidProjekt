package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.bazaarandroid.R
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.EMAIL
import com.example.bazaarandroid.utils.Constants.PASSWORD
import com.example.bazaarandroid.utils.Constants.PHONE_NUMBER
import com.example.bazaarandroid.utils.Constants.USER_NAME
import com.example.bazaarandroid.viewmodels.RegisterViewModel
import com.example.bazaarandroid.viewmodels.RegisterViewModelFactory
import com.example.bazaarandroid.viewmodels.UpdateProfileViewModel
import com.example.bazaarandroid.viewmodels.UpdateProfileViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch


class SettingsOwnerFragment : Fragment() {
    private lateinit var updateViewModel: UpdateProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = UpdateProfileViewModelFactory(this.requireContext(), Repository())
        updateViewModel = ViewModelProvider(this, factory).get(UpdateProfileViewModel::class.java)
        Log.d("xxx", "provider megvan:")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inf: View = inflater.inflate(R.layout.fragment_settings_owner, container, false)
        val tv = inf.findViewById<View>(R.id.textView_name) as TextView
        tv.text = USER_NAME

        val btn: FloatingActionButton = inf.findViewById(R.id.floatingActionButton2)

        val imageLoad = registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback
        {
            btn.setImageURI(it)
        })

        btn.setOnClickListener {
            imageLoad.launch("image/*")
        }

        val email: TextInputEditText = inf.findViewById(R.id.textInputEdit_email)
        email.setText(EMAIL)

        val username: TextInputEditText = inf.findViewById(R.id.textInputEdit_lastname)
        username.setText(USER_NAME)

        val phone_number: TextInputEditText = inf.findViewById(R.id.textInputEdit_phone_number)
        phone_number.setText(PHONE_NUMBER.toString())

        val password: TextInputEditText = inf.findViewById(R.id.textInputEdit_password)
        password.setText(PASSWORD)

        //valtoztatasok megvalositasa
        val button: Button = inf.findViewById(R.id.button_publish)
        button.setOnClickListener {
            updateViewModel.user.value.let {
                if (it != null) {
                    it.username = username.text.toString()
                    Log.i("xxx", "Name -> String:")

                    //eltarolom, hogy leszek, legyek kepben
                    USER_NAME = username.text.toString()
                }
                if (it != null) {
                    it.password = password.text.toString()
                    Log.i("xxx", "Password -> String:")
                }
                if (it != null) {
                    it.phone_number = phone_number.text.toString().toLong()
                    Log.i("xxx", "Password -> String:")
                }
            }
            lifecycleScope.launch {
                updateViewModel.update()
                if (Constants.ERROR != 5)
                {
                    Log.i("xxx", "Meg volt az Update:")
                    Toast.makeText(context,"Update was successful!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Log.d("xxx", "Nincs Update:")
                    Toast.makeText(context,"Update was not successful!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return inf
    }
}