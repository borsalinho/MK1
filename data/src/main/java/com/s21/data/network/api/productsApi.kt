package com.s21.data.network.api

import com.s21.data.network.model.ProductsDto
import retrofit2.http.GET

interface ProductsApi {
    @GET("/products?&select=title,description,images")
    suspend fun getProducts() : ProductsDto
}