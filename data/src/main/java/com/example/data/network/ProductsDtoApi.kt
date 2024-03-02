package com.example.data.network

import com.example.data.network.models.ApiResultDto
import retrofit2.http.GET

interface ProductsDtoApi {
    @GET("/products")
    suspend fun getProducts(): ApiResultDto
}