package com.s21.data.implementations

import com.s21.data.mappers.toProducts
import com.s21.data.network.api.ProductsApi

import com.s21.domain.models.Products
import com.s21.domain.repository.NetworkRepository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepositoryImpl() : NetworkRepository {

    private val baseUrl = "https://dummyjson.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productsApi = retrofit.create(ProductsApi::class.java)

    override suspend fun getDataFromApi() : Products {
        return productsApi.getProducts().toProducts()
    }
}