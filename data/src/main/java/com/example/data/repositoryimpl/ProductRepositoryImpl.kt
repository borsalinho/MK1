package com.example.data.repositoryimpl

import com.example.data.network.models.ApiResultDto
import com.example.data.storage.database.ProductsDB
import com.example.domain.models.Products
import com.example.domain.repository.ProductRepository
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL =
    "https://dummyjson.com"

class ProductRepositoryImpl : ProductRepository {

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

//    val db = ProductsDB.getDataBase()

    override fun getProducts(): Products {
//        val productApi = retrofit.create(ApiResultDto::class.java)
        TODO()
    }
}