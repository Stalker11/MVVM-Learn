package com.example.mvvm_learn.network

import com.example.mvvm_learn.ApiUser

interface ApiHelper {
    suspend fun getUsers():List<ApiUser>
}