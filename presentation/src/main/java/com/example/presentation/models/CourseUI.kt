package com.example.presentation.models

import java.util.Date

data class CourseUI(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rate: String,
    val isFavorite: Boolean,
    val startDate: Date,
)