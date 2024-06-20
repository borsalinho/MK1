package com.s21.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.s21.data.storage.dao.ProductDao
import com.s21.data.storage.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductsDB : RoomDatabase() {
    abstract fun productDao() : ProductDao
}