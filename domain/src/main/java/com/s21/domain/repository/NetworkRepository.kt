package com.s21.domain.repository

import com.s21.domain.models.Products

interface NetworkRepository {
    suspend fun getDataFromApi() : Products
}