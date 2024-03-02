package com.example.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Float,
    val rating:Float,
    val stock: Float,
    val brand: String,
    val category: String,
    val thumbnail: String,
//    @Ignore
//    val images: List<String>
    )
