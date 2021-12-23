package com.example.bazaarandroid.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.MyProduct
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.ID_PRODUCT
import kotlinx.coroutines.launch

class MyDetailProductViewModel (private val repository: Repository) : ViewModel() {
    var product_my: MyProduct = MyProduct()

    init{
        getProductLast()
    }

    fun getProductLast() {
        viewModelScope.launch {
            try {
                val result = repository.getProductLast(MyApplication.token, MyApplication.filter)

                product_my.title = result.title
                product_my.is_active = result.is_active
                product_my.price_per_unit = result.price_per_unit
                product_my.amount_type = result.amount_type
                product_my.units = result.units
                product_my.description = result.description
                product_my.price_type = result.price_type

                Log.i("xxx", "title - amit kaptam: ${product_my.title}")
                Log.i("xxx", "is_active - amit kaptam: ${product_my.is_active}")
                Log.i("xxx", "price_per_unit - amit kaptam: ${product_my.price_per_unit}")

            }catch(e: Exception){
                Log.d("xxx", "MyDetailProductViewModel exception: ${e.toString()}")
            }
        }
    }
}