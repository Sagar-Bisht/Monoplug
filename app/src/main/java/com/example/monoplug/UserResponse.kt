package com.example.monoplug

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class UserResponse(
//    @field:SerializedName("data")
//    val data: Data? = null,
//    @field:SerializedName("message")
//    val message: String? = null,
//    @field:SerializedName("success")
//    val success: Boolean? = null
//) : Parcelable
//
//@Parcelize
//data class Data(
//    @field:SerializedName("token")
//    val token: String? = null,
//    @field:SerializedName("type")
//    val type: String? = null,
//    @field:SerializedName("userId")
//    val userId: String? = null
//): Parcelable

data class UserResponse(
    @field:SerializedName("data")
    val data: Data ,
    @field:SerializedName("message")
    val message: String ,
    @field:SerializedName("success")
    val success: Boolean
)

data class Data(
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("success")
    val success: Boolean
)