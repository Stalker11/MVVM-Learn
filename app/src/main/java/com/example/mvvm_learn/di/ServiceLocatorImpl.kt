package com.example.mvvm_learn.di

import com.example.mvvm_learn.network.ApiHelper
import com.example.mvvm_learn.network.ApiHelperImpl
import com.example.mvvm_learn.network.RetrofitBuilder
import com.example.mvvm_learn.repository.UserRepo
import com.example.mvvm_learn.repository.UserRepoImpl

class ServiceLocatorImpl : ServiceLocator {
    private val apiHelper by lazy { ApiHelperImpl(RetrofitBuilder.apiService) }
    private val userRepo by lazy { UserRepoImpl(apiHelper) }
    override fun getUserRepo(): UserRepo {
        return userRepo
    }

    override fun getApiHelper(): ApiHelper {
        return apiHelper
    }
}