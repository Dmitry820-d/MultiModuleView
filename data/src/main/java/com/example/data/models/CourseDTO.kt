package com.example.data.models

import com.example.domain.models.CourseDomain
import com.example.domain.models.CoursesDomain
import com.google.gson.annotations.SerializedName
import java.util.Date

data class CourseDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("text") val description: String,
    @SerializedName("price") val price: String,
    @SerializedName("rate") val rate: String,
    @SerializedName("hasLike") val isFavorite: Boolean,
    @SerializedName("startDate") val startDate: Date,
){
    fun mapToCourseDomain(): CourseDomain =
        CourseDomain(
            id = id,
            title = title,
            description = description,
            price = price,
            rate = rate,
            isFavorite = isFavorite,
            startDate = startDate
        )
}