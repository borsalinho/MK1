package com.s21.data.implementations

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.s21.data.mappers.toProduct
import com.s21.data.mappers.toProductEntity
import com.s21.data.storage.database.ProductsDB
import com.s21.domain.models.Product
import com.s21.domain.repository.DataRepository

class DataRepositoryImpl(context : Context) : DataRepository {

    private val productsDB = Room.databaseBuilder(
        context,
        ProductsDB::class.java,
        "products-db"
        ).build()

    private val productDao = productsDB.productDao()

    override suspend fun getProductsFromDB() : List<Product> {
        return productDao.getProducts().map { it.toProduct() }
    }
    override suspend fun insertProductsToBD(products: List<Product>) {
        productDao.insertProductsEntity(products.map { it.toProductEntity() })
    }
}