package com.example.bazaarandroid.api

import com.example.bazaarandroid.MyApplication.Companion.limit
import com.example.bazaarandroid.model.LoginRequest
import com.example.bazaarandroid.model.LoginResponse
import com.example.bazaarandroid.model.ProductResponse
//import com.example.bazaarandroid.model.UserResponse
import com.example.bazaarandroid.utils.Constants
import retrofit2.Response
import retrofit2.http.*

interface MarketApi {
    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET(Constants.GET_PRODUCT_URL)
    suspend fun getProducts(@Header("token") token: String, @Header("limit") limit:Int = 100): ProductResponse

    //@GET(Constants.GET_USER_URL)
    //suspend fun getUsers(@Header("token") token: String): UserResponse
}