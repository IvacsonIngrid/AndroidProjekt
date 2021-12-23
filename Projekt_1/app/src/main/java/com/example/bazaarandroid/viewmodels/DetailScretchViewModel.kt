package com.example.bazaarandroid.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bazaarandroid.MyApplication
import com.example.bazaarandroid.model.*
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.ID_PRODUCT

class DetailScretchViewModel (val context: Context, val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var product = MutableLiveData<MyProduct>()

    init {
        product.value = MyProduct()
    }

    suspend fun addProduct() {
        val request =
            AddProductRequest(title = product.value!!.title,
                description = product.value!!.description,
                price_per_unit = product.value!!.price_per_unit,
                units = product.value!!.units,
                is_active = product.value!!.is_active,
                rating = product.value!!.rating,
                amount_type = product.value!!.amount_type,
                price_type = product.value!!.price_type)

        try {
            val result = repository.addProduct(MyApplication.token, request)
            Log.d("xxx", "${result.creation}")
            ID_PRODUCT = result.product_id
            Log.d("xxx", "A TERMEK ID: $ID_PRODUCT")

        } catch (e: Exception) {
            Log.d("xxx", "DetailScretchViewModel - exception: ${e.toString()}")
            Constants.ERROR = 2
        }
    }
}