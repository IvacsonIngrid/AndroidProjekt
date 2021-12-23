package com.example.bazaarandroid.model

import com.squareup.moshi.JsonClass
import java.math.BigInteger

//import com.google.gson.annotations.SerializedName

data class User(
    var username: String="",
    var password: String="",
    var email: String="",
    var phone_number: String=""
)

data class MyUser(
    var username: String="",
    var password: String="",
    var email: String="",
    var phone_number: Long = 7111111111
)

@JsonClass(generateAdapter = true)
data class LoginRequest (
    var username: String,
    var password: String
)

@JsonClass(generateAdapter = true) //amit beadok
data class RegisterRequest (
    var username: String,
    var password: String,
    var email: String,
    var phone_number: Long
)

@JsonClass(generateAdapter = true)
data class LoginResponse (
    var username: String,
    var email: String,
    var phone_number: Long,
    var token: String,
    var creation_time: Long,
    var refresh_time: Long
)

@JsonClass(generateAdapter = true) //amit visszaterit
data class RegisterResponse (
    var code: Int,
    var message: String,
    var creation_time: Long,
    var token: String
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