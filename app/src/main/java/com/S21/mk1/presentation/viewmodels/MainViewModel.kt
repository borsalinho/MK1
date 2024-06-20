package com.S21.mk1.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s21.domain.usecases.GetDataUseCase
import kotlinx.coroutines.launch

class MainViewModel (
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {
    fun getProducts(){
        viewModelScope.launch{
            try {
                val res = getDataUseCase.execute()
                res.map { Log.d("MyTag", it.toString()) }

            } catch (e:Exception){
                Log.d("MyTag", e.toString())
            }

        }
    }
}