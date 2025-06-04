package com.example.data.models

import com.example.domain.models.CoursesDomain
import com.google.gson.annotations.SerializedName

data class CoursesDTO(
    @SerializedName("courses") val courses: List<CourseDTO>
) {
    fun mapToCoursesDomain(): CoursesDomain {

        val listCoursesDomain = courses.map { it.mapToCourseDomain() }
        return CoursesDomain(courses = listCoursesDomain)
    }
}