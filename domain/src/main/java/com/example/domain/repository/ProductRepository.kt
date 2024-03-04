package com.example.domain.repository

import com.example.domain.models.Products


interface ProductRepository {

    fun getProducts(): Products

//    fun saveName(saveParam: SaveUserName) : Boolean
//
//    fun getName() : UserName
}