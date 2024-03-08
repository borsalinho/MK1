package com.example.domain.repository

import com.example.domain.models.Products


interface ProductsRepository {

    fun getProducts(): Products

}