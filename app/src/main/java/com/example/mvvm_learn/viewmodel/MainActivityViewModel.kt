package com.example.mvvm_learn.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_learn.ApiUser
import com.example.mvvm_learn.di.ServiceLocator
import com.example.mvvm_learn.network.ApiHelper
import com.example.mvvm_learn.utils.ResultReading
import com.example.mvvm_learn.utils.Status
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.*

class MainActivityViewModel(val serviceLocator: ServiceLocator) : BaseViewModel() {
    val textUpdater: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val updateUsers: MutableLiveData<ResultReading<List<ApiUser>>> by lazy { MutableLiveData<ResultReading<List<ApiUser>>>() }
    val updateDate = MutableLiveData<Long>()
    private lateinit var coroutineScope: Job

    fun getUsers() {
        updateUsers.postValue(ResultReading.onLoading(null, Status.LOADING))
        coroutineScope = viewModelScope.launch {
            serviceLocator.getUserRepo().fetchUserData {
                updateUsers.postValue(it)
                updateDate.postValue(requestTime())
            }
        }
//        try {
//            coroutineScope = viewModelScope.launch(exceptionHandler) {
//                updateUsers.postValue(ResultReading.onSuccess(helper.getUsers(),Status.SUCCESS))
//            }
//        }catch (e: Exception){
//            updateUsers.postValue(ResultReading.onError("Coroutine error", Status.ERROR))
//        }
    }

    @Deprecated("See previous lesson")
    fun updateString() {
        //postValue using if you call method from background thread
        //setValue JUST for MAINTHREAD
        textUpdater.postValue("Hello Kotlin")
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        updateUsers.postValue(ResultReading.onError("Coroutine error", Status.ERROR))
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancelChildren()
    }
    private fun requestTime() = Calendar.getInstance().time.time
}