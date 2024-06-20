package com.s21.data.mappers

import com.s21.data.storage.model.ProductEntity
import com.s21.domain.models.Product

fun Product.toProductEntity() : ProductEntity {
    return ProductEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        images = this.images.joinToString(",")
    )
}