package com.S21.productsapi.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("price") val price : Double,
    @SerializedName("images") val images : List<String>
)