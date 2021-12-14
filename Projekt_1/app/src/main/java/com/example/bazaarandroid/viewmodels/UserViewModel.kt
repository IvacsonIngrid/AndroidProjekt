package com.example.bazaarandroid.viewmodels

import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.Product
//import com.example.bazaarandroid.model.ProfileData
import com.example.bazaarandroid.model.User
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import kotlinx.coroutines.launch

/*class UserViewModel(private val repository: Repository) : ViewModel() {
    var users: MutableLiveData<List<ProfileData>> = MutableLiveData()

    init{
        Log.d("xxx", "UserViewModel constructor - Token: ${MyApplication.token}")
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                val result =
                    repository.getUsers(MyApplication.token)
                users.value = result.users
                Log.d("xxx", "ListViewModel - #products:  ${result.item_count}")

                //tarolom h osszesen hany termek van
                Constants.NUMB_PRODUCTS = result.item_count
            }catch(e: Exception){
                Log.d("xxx", "ListViewMofdel exception: ${e.toString()}")
            }
        }
    }
}*/