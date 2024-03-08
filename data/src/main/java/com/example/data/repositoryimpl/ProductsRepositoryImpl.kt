package com.example.data.repositoryimpl

import com.example.data.network.ProductsDtoApi
import com.example.data.storage.dao.ProductsDao
import com.example.domain.models.Products
import com.example.domain.repository.ProductsRepository


class ProductsRepositoryImpl(var productsDtoApi: ProductsDtoApi) : ProductsRepository {

    override fun getProducts(): Products {
        // логика получение из сети
        productsDtoApi.getProducts()
        // сохрание в БД

        TODO()
    }
}