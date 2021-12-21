package com.example.bazaarandroid.api

import com.example.bazaarandroid.model.*
//import com.example.bazaarandroid.model.UserResponse
import com.example.bazaarandroid.utils.Constants
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.*

interface MarketApi {
    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET(Constants.GET_PRODUCT_URL)
    suspend fun getProducts(@Header("token") token: String, @Header("limit") limit:Int = 200): ProductResponse

    //@GET(Constants.GET_USER_URL)
    //suspend fun getUsers(@Header("token") token: String): UserResponse

    @POST(Constants.REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    //@POST(Constants.ADD_PRODUCT_URL)
    //suspend fun addProduct(@Header("token") token: String, @Body request: AddProductRequest): AddProductResponse

    @Multipart
        @JsonClass(generateAdapter = true)
        @POST(Constants.ADD_PRODUCT_URL)
        suspend fun addProduct(@Header("token") token: String,
                               @Part ("title") title: String,
                               @Part ("description") description: String,
                               @Part ("price_per_unit") price_per_unit: String,
                               @Part ("units") units: String,
                               @Part ("is_active") is_active: Boolean,
                               @Part ("rating") rating: Double,
                               @Part ("amount_type") amount_type: String,
                               @Part ("price_type") price_type: String): AddProductResponse
}