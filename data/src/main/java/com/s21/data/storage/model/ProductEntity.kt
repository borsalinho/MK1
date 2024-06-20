package com.s21.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title : String,
    val description : String,
    val images : String
)