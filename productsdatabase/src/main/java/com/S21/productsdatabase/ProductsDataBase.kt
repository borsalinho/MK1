package com.S21.productsdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.S21.productsdatabase.dao.ProductDao
import com.S21.productsdatabase.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductsDataBase : RoomDatabase() {
    abstract fun productDao() : ProductDao
}

fun ProductsDataBase(applicationContext: Context){
    val db = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        ProductsDataBase::class.java,
        "products-db"
    ).build()
}