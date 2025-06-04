package com.example.presentation.mappers

import com.example.domain.LoadCourseResult
import com.example.domain.models.CourseDomain
import com.example.domain.models.CoursesDomain
import com.example.presentation.CourseUIState
import com.example.presentation.models.CourseUI
import javax.inject.Inject

class CourseUIMapper @Inject constructor(): LoadCourseResult.Mapper<CourseUIState>  {
    override fun mapSuccess(coursesDomain: CoursesDomain): CourseUIState {
        val listCoursesUI = coursesDomain.courses.map { it.toCourseUI() }
        return CourseUIState.Success(listCourse = listCoursesUI)
    }

    override fun mapError(message: String): CourseUIState {
        return CourseUIState.Error(message = message)
    }
}

fun CourseDomain.toCourseUI(): CourseUI = CourseUI(
    id = id,
    title = title,
    description = description,
    price = price,
    rate = rate,
    isFavorite = isFavorite,
    startDate = startDate
)