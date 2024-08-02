package com.S21.productsapi

import androidx.annotation.IntRange
import com.S21.productsapi.models.ProductDTO
import com.S21.productsapi.models.ResponseDTO
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * для работы только с этим публичным API, поэтому URL пусть будет тут
 * API details [here](https://dummyjson.com/docs/products)
 */
internal const val BASE_URL = "https://dummyjson.com"

interface ProductsApi {
    @GET("/products")
    suspend fun getProducts(
        @Query("limit") @IntRange(from = 0, to = 194) limit: Int = 30,
        @Query("skip") @IntRange(from = 0, to = 194) skip: Int = 0,
        @Query("select") select: String = "title,description,images,price"
    ) : Result<ResponseDTO<ProductDTO>>
}

fun ProductsApi(
    okHttpClient: OkHttpClient? = null,
) : ProductsApi {
    return retrofit(okHttpClient = okHttpClient).create(ProductsApi::class.java)
}

private fun retrofit(
    okHttpClient: OkHttpClient?,
) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .run { if(okHttpClient != null) client(okHttpClient) else this }
        .build()
}