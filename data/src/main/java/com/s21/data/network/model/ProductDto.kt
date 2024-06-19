package com.s21.data.network.model

data class ProductDto(
    val id : Int,
    val title : String,
    val description : String,
    val images : List<String>
)
