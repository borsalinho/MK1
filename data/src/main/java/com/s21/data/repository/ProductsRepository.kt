package com.s21.data.repository

import com.S21.productsapi.ProductsApi
import com.S21.productsdatabase.ProductsDataBase
import com.s21.data.model.Product
import kotlinx.coroutines.flow.Flow

class ProductsRepository(
    private val database: ProductsDataBase,
    private val api: ProductsApi,
) {
    fun getAll() : Flow<List<Product>> {
        return api.getProducts() // mapper
    }
}