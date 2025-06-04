package com.example.domain.models

import java.util.Date

data class CourseDomain(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rate: String,
    val isFavorite: Boolean,
    val startDate: Date,
)