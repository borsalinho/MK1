package com.example.data.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.storage.dao.ProductsDao
import com.example.data.storage.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductsDB: RoomDatabase() {
    abstract fun getDao() : ProductsDao

    companion object{
        fun getDataBase(context: Context): ProductsDB{
            return Room.databaseBuilder(
                context.applicationContext,
                ProductsDB::class.java,
                "products.db"
            ).build()
        }
    }
}