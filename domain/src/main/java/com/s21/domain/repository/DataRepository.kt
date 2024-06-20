package com.s21.domain.repository

import com.s21.domain.models.Product


interface DataRepository {

    suspend fun getProductsFromDB() : List<Product>
    suspend fun insertProductsToBD(products: List<Product>)

}