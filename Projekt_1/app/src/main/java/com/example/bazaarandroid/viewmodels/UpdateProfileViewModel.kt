package com.example.bazaarandroid.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bazaarandroid.MyApplication.Companion.token
import com.example.bazaarandroid.model.MyUser
import com.example.bazaarandroid.model.RegisterRequest
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants.ERROR

class UpdateProfileViewModel (val context: Context, val repository: Repository) : ViewModel()  {
    var user = MutableLiveData<MyUser>()

    init {
        user.value = MyUser()
    }

    suspend fun update() {
        val request =
            RegisterRequest(username = user.value!!.username, password = user.value!!.password,
                email = user.value!!.email, phone_number = user.value!!.phone_number)
        Log.d("xxx", "${user.value!!.username}, ${user.value!!.password}, ${user.value!!.email}, ${user.value!!.phone_number}")
        try {
            val result = repository.update(token,request)
            token = result.token

        } catch (e: Exception) {
            Log.d("xxx", "UpdateProfileViewModel - exception: ${e.toString()}")
            ERROR = 5
        }
    }
}