package com.example.data

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("quote")
    val quote: String
)
