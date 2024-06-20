package com.s21.domain.usecases

import com.s21.domain.models.Product
import com.s21.domain.repository.Repository

class GetDataUseCase(private val repository: Repository) {
    suspend fun execute() : List<Product>{
        return repository.getProducts()
    }
}