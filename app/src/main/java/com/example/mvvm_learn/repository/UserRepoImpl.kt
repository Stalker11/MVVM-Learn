package com.example.mvvm_learn.repository

import com.example.mvvm_learn.ApiUser
import com.example.mvvm_learn.network.ApiHelper
import com.example.mvvm_learn.utils.ResultReading
import com.example.mvvm_learn.utils.Status
import java.lang.Exception

class UserRepoImpl(val apiHelper: ApiHelper) : UserRepo {
    override suspend fun fetchUserData(callback: (ResultReading<List<ApiUser>>) -> Unit) {
        try {
            val usersFromDb = apiHelper.getUsers()
            callback.invoke(ResultReading.onSuccess(usersFromDb, Status.SUCCESS))
        } catch (e: Exception) {
            callback.invoke(ResultReading.onError(e.message, Status.ERROR))
        }
    }
}