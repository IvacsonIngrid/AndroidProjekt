package com.example.bazaarandroid.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.Orders
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import kotlinx.coroutines.launch

class MyFaresViewModel (private val repository: Repository) : ViewModel(){
    var orders: MutableLiveData<List<Orders>> = MutableLiveData()
    var currentPosition: Int = 0

    init{
        Log.d("xxx", "MyFares constructor - Token: ${MyApplication.token}")
        getOrders()
    }

    fun getOrders() {
        viewModelScope.launch {
            try {
                val result = repository.getOrders(MyApplication.token, MyApplication.limit)
                orders.value = result.orders
                Log.d("xxx", "Atadta a megrendeleseket")

            }catch(e: Exception){
                Log.d("xxx", "MyFares exception: ${e.toString()}")
            }
        }
    }
}