package com.s21.products.main

import com.s21.data.model.Product
import com.s21.data.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetAllProductsUseCase(
    private val repository: ProductsRepository
) {
    operator fun invoke() : Flow<List<Product>> {
        return repository.getAll()
    }
}