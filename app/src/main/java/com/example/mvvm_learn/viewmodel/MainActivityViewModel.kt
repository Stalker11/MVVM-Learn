package com.example.mvvm_learn.viewmodel

import androidx.lifecycle.MutableLiveData

class MainActivityViewModel():BaseViewModel() {
    val textUpdater:MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun updateString(){
        //postValue using if you call method from background thread
        //setValue JUST for MAINTHREAD
            textUpdater.postValue("Hello Kotlin")
    }
}