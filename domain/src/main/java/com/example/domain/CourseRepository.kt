package com.example.domain

interface CourseRepository {
    suspend fun loadNews(): LoadCourseResult
}