package com.s21.data.mappers

import com.s21.data.network.model.ProductsDto
import com.s21.domain.models.Products

fun ProductsDto.toProducts() : Products {
    return Products(
        products = this.products.map { it.toProduct() },
        total = this.total,
        skip = this.skip,
        limit = this.limit
    )
}