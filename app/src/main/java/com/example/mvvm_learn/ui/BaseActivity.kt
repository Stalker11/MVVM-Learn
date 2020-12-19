package com.example.mvvm_learn.ui

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}