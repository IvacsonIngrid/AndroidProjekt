package com.example.bazaarandroid.model

import com.squareup.moshi.JsonClass

//import com.google.gson.annotations.SerializedName

data class User(var username: String="", var password: String="", val email: String="", var phone_number: String="")

@JsonClass(generateAdapter = true)
data class LoginRequest (
    var username: String,
    var password: String
)

@JsonClass(generateAdapter = true)
data class LoginResponse (
    var username: String,
    var email: String,
    var phone_number: Int,
    var token: String,
    var creation_time: Long,
    var refresh_time: Long
)

/*@JsonClass(generateAdapter = true)
data class ProfileData (
    var username: String,
    var email: String,
    var phone_number: Int,
    var password: String
)

@JsonClass(generateAdapter = true)
data class UserResponse(val item_count: Int, val users: List<ProfileData>, val timestamp: Long)*/


// GSon converter
//data class LoginRequest (
//    @SerializedName("username")
//    var username: String,
//
//    @SerializedName("password")
//    var password: String
//)
//
//
//data class LoginResponse (
//    @SerializedName("username")
//    var username: String,
//
//    @SerializedName("email")
//    var email: String,
//
//    @SerializedName("phone_number")
//    var phone_number: Int,
//
//    @SerializedName("token")
//    var token: String,
//
//    @SerializedName("creation_time")
//    var creation_time: Long,
//
//    @SerializedName("refresh_time")
//    var refresh_time: Long
//)