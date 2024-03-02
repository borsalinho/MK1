package com.example.data.network.models

data class ApiResultDto(
    val products: ProductsDto,
    val total: Int,
    val skip: Int,
    val limit: Int
)
