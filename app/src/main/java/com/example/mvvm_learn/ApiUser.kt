package com.example.mvvm_learn

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("id")
    @Expose
    val id: Int = 0,
    @Expose
    @SerializedName("name")
    val name: String = "",
    @Expose
    @SerializedName("email")
    val email: String = "",
    @Expose
    @SerializedName("avatar")
    val avatar: String = ""

)
