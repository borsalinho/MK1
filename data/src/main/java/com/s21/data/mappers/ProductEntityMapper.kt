package com.s21.data.mappers

import com.s21.data.storage.model.ProductEntity
import com.s21.domain.models.Product

fun ProductEntity.toProduct() : Product {
    return Product(
        id = this.id,
        title = this.title,
        description = this.description,
        images = this.images.split(",").map { it.trim() }.filter { it.isNotBlank() }
    )
}