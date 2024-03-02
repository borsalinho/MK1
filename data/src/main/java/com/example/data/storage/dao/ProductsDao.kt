package com.example.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.storage.models.ProductEntity

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(products: ProductEntity)

    @Query("select * from products")
    fun getProducts(): LiveData<ProductEntity>
}