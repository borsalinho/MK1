package com.example.data.extension

import com.example.data.network.models.ProductDto
import com.example.data.storage.models.ProductEntity

fun ProductEntity.toDto(): ProductDto {
    return ProductDto(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        discountPercentage = this.discountPercentage,
        rating = this.rating,
        stock = this.stock,
        brand = this.brand,
        category = this.category,
        thumbnail = this.thumbnail,
        images = this.images
    )
}