package com.example.mvvm_learn.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvm_learn.R
import com.example.mvvm_learn.databinding.ActivityMainBinding
import com.example.mvvm_learn.di.ServiceLocatorImpl
import com.example.mvvm_learn.utils.ResultReading
import com.example.mvvm_learn.utils.ViewModelFactoryMVVM
import com.example.mvvm_learn.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private val serviceLocator by lazy { ServiceLocatorImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelFactoryMVVM(serviceLocator).create(MainActivityViewModel::class.java)//.get(MainActivityViewModel::class.java)
        viewModel.textUpdater.observe(this, Observer {
            binding.activityMainText.text = it
            resources?.getString(R.string.activity_main_textUpdated)?.let { it1 -> showToast(it1) }
        })
        viewModel.updateUsers.observe(this, {
            when(it) {
                is ResultReading.onLoading -> {

                }
                is ResultReading.onSuccess -> {
                    binding.activityMainText.text = it.data.get(0).email
                }
                is ResultReading.onError -> {
                    binding.activityMainText.text = it.message
                }
            }
          //
        })
        binding.activityMainButton.setOnClickListener {
           viewModel.getUsers()
        }
    }
}