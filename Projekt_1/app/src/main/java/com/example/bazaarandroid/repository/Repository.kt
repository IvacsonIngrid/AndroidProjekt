package com.example.bazaarandroid.repository

import android.util.Log
import com.example.bazaarandroid.api.RetrofitInstance
import com.example.bazaarandroid.model.LoginRequest
import com.example.bazaarandroid.model.LoginResponse
import com.example.bazaarandroid.model.ProductResponse
//import com.example.bazaarandroid.model.UserResponse

class Repository {
    suspend fun login(request: LoginRequest): LoginResponse {
        return RetrofitInstance.api.login(request)
    }

    suspend fun getProducts(token: String, limit: Int): ProductResponse {
        return RetrofitInstance.api.getProducts(token, limit)
    }

    /*suspend fun getUsers(token: String): UserResponse {
        return RetrofitInstance.api.getUsers(token)
    }*/
}