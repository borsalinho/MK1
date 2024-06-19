package com.s21.domain.usecases

import com.s21.domain.repository.Repository

class GetDataUseCase(private val repository: Repository) {
    fun execute(){
        repository.getData()
    }
}