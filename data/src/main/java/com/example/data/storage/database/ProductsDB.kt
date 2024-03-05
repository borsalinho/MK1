package com.example.data.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.data.storage.dao.ProductsDao
import com.example.data.storage.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(Converters::class)
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

class Converters {
    @TypeConverter
    fun fromStringList(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    fun toStringList(list: List<String>): String {
        return list.joinToString(",")
    }
}