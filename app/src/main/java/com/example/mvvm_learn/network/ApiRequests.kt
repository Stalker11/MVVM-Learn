package com.example.mvvm_learn.network

import com.example.mvvm_learn.ApiUser
import retrofit2.http.GET

interface ApiRequests {
    @GET("/users")
    suspend fun getUsers():List<ApiUser>
}