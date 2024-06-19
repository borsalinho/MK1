package com.s21.domain.models

data class Products(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
