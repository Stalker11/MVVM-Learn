package com.example.mvvm_learn.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_learn.di.ServiceLocator
import com.example.mvvm_learn.network.ApiHelper
import com.example.mvvm_learn.viewmodel.MainActivityViewModel

class ViewModelFactoryMVVM(val serviceLocator: ServiceLocator): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
          return MainActivityViewModel(serviceLocator) as T
      }
        throw IllegalArgumentException("Unknown class name")
    }
}