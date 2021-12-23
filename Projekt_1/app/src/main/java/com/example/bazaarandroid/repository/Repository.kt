package com.example.bazaarandroid.repository

import com.example.bazaarandroid.api.RetrofitInstance
import com.example.bazaarandroid.model.*

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

    suspend fun register(request: RegisterRequest): RegisterResponse {
        return RetrofitInstance.api.register(request)
    }

    suspend fun addProduct(token: String, request: AddProductRequest): AddProductResponse {
        return RetrofitInstance.api.addProduct(token, request.title, request.description, request.price_per_unit,
        request.units, request.is_active, request.rating, request.amount_type, request.price_type)
    }

    suspend fun getProductLast(token: String, filter: String): AddProductResponse {
        return RetrofitInstance.api.getProductLast(token, filter)
    }

    suspend fun update(token: String, request: RegisterRequest): RegisterResponse {
        return RetrofitInstance.api.update(token, request)
    }

    suspend fun getOrders(token: String, limit: Int): ProductSalesResponse {
        return RetrofitInstance.api.getOrders(token, limit)
    }
}