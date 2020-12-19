package com.example.mvvm_learn.network

import com.example.mvvm_learn.ApiUser

class ApiHelperImpl(private val apiService: ApiRequests):ApiHelper {
    override suspend fun getUsers(): List<ApiUser> = apiService.getUsers()
}