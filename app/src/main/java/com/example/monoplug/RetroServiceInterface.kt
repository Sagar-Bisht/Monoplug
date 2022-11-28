package com.example.monoplug

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @Multipart
    @POST("user/register")
    fun createUser(
        @Part("firstName")
        firstName: String,
        @Part("lastName")
        lastName: String,
        @Part("email")
        email: String,
        @Part("password")
        password: String,
        @Part("isArtist")
        isArtist: Boolean,
        @Part
        image: MultipartBody.Part?
    ): Call<UserResponse>

    @POST("user/login")
    fun loginUser(@Body loginModel :LoginModel) : Call<UserResponse>

}