package com.example.domain

import com.example.domain.models.CoursesDomain

interface LoadCourseResult {

    fun <T: Any> map(mapper: Mapper<T>): T

    interface Mapper<T: Any> {
        fun mapSuccess(coursesDomain: CoursesDomain): T
        fun mapError(message: String): T
    }

    data class Success(private val courses: CoursesDomain): LoadCourseResult{
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(courses)
        }

    }
    data class Error(private val message: String): LoadCourseResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(message)
        }
    }

}