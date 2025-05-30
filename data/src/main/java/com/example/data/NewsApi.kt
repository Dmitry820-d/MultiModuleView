package com.example.data

import retrofit2.http.GET

interface NewsApi {

    @GET("api/random")
    suspend fun getNews(): String

}