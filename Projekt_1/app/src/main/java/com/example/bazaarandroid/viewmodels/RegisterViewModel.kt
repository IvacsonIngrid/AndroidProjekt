package com.example.bazaarandroid.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.MyUser
import com.example.bazaarandroid.model.RegisterRequest
import com.example.bazaarandroid.model.User
import com.example.bazaarandroid.repository.Repository

class RegisterViewModel (val context: Context, val repository: Repository) : ViewModel()  {
    var user = MutableLiveData<MyUser>()

    init {
        user.value = MyUser()
    }

    suspend fun register() {
        val request =
            RegisterRequest(username = user.value!!.username, password = user.value!!.password,
                email = user.value!!.email, phone_number = user.value!!.phone_number)
            Log.d("xxx", "${user.value!!.username}, ${user.value!!.password}, ${user.value!!.email}, ${user.value!!.phone_number}")
        try {
            val result = repository.register(request)
            Log.d("xxx", "${result.message}")
        } catch (e: Exception) {
            Log.d("xxx", "LoginViewModel - exception: ${e.toString()}")
        }
    }
}