package com.S21.mk1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.s21.domain.usecases.GetDataUseCase

class MainViewModel(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {
    fun getData(){
        getDataUseCase.execute()
    }
}