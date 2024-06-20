package com.s21.domain.repository

import android.util.Log
import com.s21.domain.models.Product
import com.s21.domain.models.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(
    private val dataRepository: DataRepository,
    private val networkRepository: NetworkRepository
) {

    suspend fun getProducts() : List<Product> {

        var products = getProductFromDB()

        if (products.isEmpty() ) {
         val productsFromApi = getProductsFromApi().products
         saveProductToDB(productsFromApi)
         products = getProductFromDB()
        }

        return products
    }

    private suspend fun getProductsFromApi() : Products {
        return withContext(Dispatchers.IO) {
            try {
                networkRepository.getProductsFromApi()
            } catch (e: Exception) {
                throw Exception("Cant load from API")
            }
        }
    }

    private suspend fun getProductFromDB() : List<Product> {
        return withContext(Dispatchers.IO) {
            try {
                dataRepository.getProductsFromDB()
            } catch (e: Exception) {
                throw Exception("Cant load from DB")
            }
        }
    }

    private suspend fun saveProductToDB(products: List<Product>) {
        withContext(Dispatchers.IO) {
            try {
                dataRepository.insertProductsToBD(products)
            } catch (e: Exception) {
                throw Exception("Cant load to DB")
            }
        }
    }
}