package com.s21.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.s21.data.storage.model.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductsEntity(productsEntity: List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun getProducts() : List<ProductEntity>
}