package com.example.bazaarandroid.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.USER_NAME
import kotlinx.coroutines.launch

class MyMarketViewModel (private val repository: Repository) : ViewModel() {
    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var product_my: ArrayList<Product> = ArrayList()
    var currentPosition: Int = 0

    init{
        Log.d("xxx", "MyMarketViewModel constructor - Token: ${MyApplication.token}")
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                val result = repository.getProducts(MyApplication.token, MyApplication.limit)

                Log.d("xxx", "MyMarketViewModel - #products:  ${result.item_count}")
                Log.d("xxx", "User, kinek termeket vallogatom: $USER_NAME")

                for(elem in result.products)
                {
                    if(elem.username == USER_NAME) //ide be kell tedd a USER_NAME reszt, ha lesz elemed
                    {
                        product_my.add(elem)
                    }
                }

                products.value = product_my

            }catch(e: Exception){
                Log.d("xxx", "MyMarketViewModel exception: ${e.toString()}")
            }
        }
    }

    fun getItem(): Product {
        Log.d("xxx", "getItem is jo? Merete a listanak: ${product_my.size}, a pozicio meg: $currentPosition")
        return product_my[currentPosition]
    }
}