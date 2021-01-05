package com.example.mvvm_learn.repository

import com.example.mvvm_learn.ApiUser
import com.example.mvvm_learn.utils.ResultReading

interface UserRepo {
   suspend fun fetchUserData(callback:(ResultReading<List<ApiUser>>) -> Unit)
}