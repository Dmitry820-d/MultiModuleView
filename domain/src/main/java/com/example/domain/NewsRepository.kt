package com.example.domain

interface NewsRepository {
    suspend fun loadNews(): Pair<Boolean, String>
}