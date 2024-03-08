package com.example.domain.usecase

import com.example.domain.models.Products
import com.example.domain.repository.ProductsRepository

class LoadProductsFromApiUseCase(private val productsRepository: ProductsRepository) {

    fun execute() : Products{
        return productsRepository.getProducts()
    }
}