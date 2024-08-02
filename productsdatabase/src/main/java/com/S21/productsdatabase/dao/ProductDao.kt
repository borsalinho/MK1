package com.S21.productsdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RawQuery
import com.S21.productsdatabase.models.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAll() : Flow<List<ProductEntity>>

    @Insert
    suspend fun insert(products : List<ProductEntity>)

    @Delete
    suspend fun remove(products : List<ProductEntity>)
    @Query("DELETE FROM products")
    suspend fun clean()
}