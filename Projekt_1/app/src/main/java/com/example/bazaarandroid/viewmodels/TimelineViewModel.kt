package com.example.bazaarandroid.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.LoginRequest
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.model.User
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants.NUMB_PRODUCTS
import com.example.bazaarandroid.utils.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import com.example.bazaarandroid.model.ProductResponse


class TimelineViewModel(private val repository: Repository) : ViewModel() {
    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var currentPosition: Int = 0

    init{
        Log.d("xxx", "ListViewModel constructor - Token: ${MyApplication.token}")
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                val result = repository.getProducts(MyApplication.token, MyApplication.limit)
                products.value = result.products
                Log.d("xxx", "ListViewModel - #products:  ${result.item_count}")

                //tarolom h osszesen hany termek van
                NUMB_PRODUCTS = result.item_count

                //settings-nek

            }catch(e: Exception){
                Log.d("xxx", "ListViewModel exception: ${e.toString()}")
            }
        }
    }

    fun getItem(): Product {
        Log.d("xxx", "getItem is jo?")
        return products.value!!?.get(currentPosition)
    }

    fun getName(): Product {
        Log.d("xxx", "getName is jo?")
        return products.value!![currentPosition]

    }
}
