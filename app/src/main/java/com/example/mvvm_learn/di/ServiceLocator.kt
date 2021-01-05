package com.example.mvvm_learn.di

import com.example.mvvm_learn.network.ApiHelper
import com.example.mvvm_learn.repository.UserRepo

interface ServiceLocator {
    fun getUserRepo():UserRepo
    fun getApiHelper():ApiHelper
}