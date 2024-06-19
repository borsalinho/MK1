package com.s21.domain.models

data class Product(
    val id : Int,
    val title : String,
    val description : String,
    val images : List<String>
)
