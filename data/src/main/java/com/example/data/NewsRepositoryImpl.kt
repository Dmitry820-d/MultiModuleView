package com.example.data

import com.example.domain.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepositoryImpl(
    private val api: NewsApi
): NewsRepository {

    constructor() : this(
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(NewsApi::class.java)

    )

    override suspend fun loadNews(): Pair<Boolean, String> {
        return try {
            Pair(true, api.getNews().toString())
        } catch (e: Exception){
            Pair(false, e.message ?: "error load news from repository")
        }
    }
}