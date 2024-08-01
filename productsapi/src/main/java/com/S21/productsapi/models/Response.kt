package com.S21.productsapi.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Response<E>(
    @SerializedName("products") val products : List<E>,
    @SerializedName("total") val total : Int,
    @SerializedName("skip") val skip : Int,
    @SerializedName("limit") val limit : Int
)

