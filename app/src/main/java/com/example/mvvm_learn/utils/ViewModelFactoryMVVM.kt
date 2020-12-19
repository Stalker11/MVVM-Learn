package com.example.mvvm_learn.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_learn.network.ApiHelper
import com.example.mvvm_learn.viewmodel.MainActivityViewModel

class ViewModelFactoryMVVM(val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
          return MainActivityViewModel(apiHelper) as T
      }
        throw IllegalArgumentException("Unknown class name")
    }
}