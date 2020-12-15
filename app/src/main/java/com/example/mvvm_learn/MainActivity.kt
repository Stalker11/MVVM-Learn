package com.example.mvvm_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_learn.databinding.ActivityMainBinding
import com.example.mvvm_learn.viewmodel.BaseViewModel
import com.example.mvvm_learn.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.textUpdater.observe(this, Observer {
            binding.activityMainText.text = it
            resources?.getString(R.string.activity_main_textUpdated)?.let { it1 -> showToast(it1) }
        })
        binding.activityMainButton.setOnClickListener {
            viewModel.updateString()
        }
    }
}