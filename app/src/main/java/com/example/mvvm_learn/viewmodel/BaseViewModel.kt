package com.example.mvvm_learn.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel():ViewModel() {
    override fun onCleared() {
        //Do something
        super.onCleared()
    }
}