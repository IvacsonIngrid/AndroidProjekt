package com.example.bazaarandroid.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.LoginRequest
import com.example.bazaarandroid.model.MyUser
import com.example.bazaarandroid.model.User
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants.EMAIL
import com.example.bazaarandroid.utils.Constants.ERROR
import com.example.bazaarandroid.utils.Constants.PASSWORD
import com.example.bazaarandroid.utils.Constants.PHONE_NUMBER
import com.example.bazaarandroid.utils.SessionManager
import kotlinx.coroutines.launch

class LoginViewModel(val context: Context, val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<MyUser>()

    init {
        user.value = MyUser()
    }

//    fun login() {
//        viewModelScope.launch {
//            val request =
//                LoginRequest(username = user.value!!.username, password = user.value!!.password)
//            try {
//                val result = repository.login(request)
//                MyApplication.token = result.token
//                token.value = result.token
//                Log.d("xxx", "MyApplication - token:  ${MyApplication.token}")
//            }catch(e: Exception){
//                Log.d("xxx", "MainViewModel - exception: ${e.toString()}")
//            }
            //      }
//    }

    suspend fun login() {
        val request =
            LoginRequest(username = user.value!!.username, password = user.value!!.password)
        try {
            val result = repository.login(request)
            MyApplication.token = result.token
            token.value = result.token

            EMAIL = result.email
            PHONE_NUMBER = result.phone_number

            Log.d("xxx", "MyApplication - token:  ${MyApplication.token}")
        } catch (e: Exception) {
            Log.d("xxx", "LoginViewModel - exception: ${e.toString()}")
            ERROR = 1
        }
    }
}

