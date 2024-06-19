package com.s21.data.mappers

import com.s21.data.network.model.ProductDto
import com.s21.domain.models.Product

fun ProductDto.toProduct(): Product {
    return Product(
        id = this.id,
        title = this.title,
        description = this.description,
        images = this.images
    )
}