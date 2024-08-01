package com.S21.productsapi

import androidx.annotation.IntRange
import com.S21.productsapi.models.Product
import com.S21.productsapi.models.Response
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

internal const val BASE_URL = "https://dummyjson.com"

interface ProductsApi {
    /**
     * API details [here](https://dummyjson.com/docs/products)
     */
    @GET("/products")
    suspend fun getProducts(
        @Query("limit") @IntRange(from = 0, to = 194) limit: Int = 30,
        @Query("skip") @IntRange(from = 0, to = 194) skip: Int = 0,
        @Query("select") select: String = "title,description,images,price"
    ) : Response<Product>
}

fun ProsuctsApi(
    okHttpClient: OkHttpClient? = null,
) : ProductsApi {
    val retrofit = retrofit( okHttpClient)
    return retrofit.create(ProductsApi::class.java)
}

private fun retrofit(
    okHttpClient: OkHttpClient?,
) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .run { if(okHttpClient != null) client(okHttpClient) else this }
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}