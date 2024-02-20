package com.example.mk1.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(){
//        val params = m
    }

}