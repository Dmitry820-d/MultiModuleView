package com.example.presentation

import com.example.presentation.models.CourseUI

interface CourseUIState {

    data class Success(val listCourse: List<CourseUI>): CourseUIState
    data class Error(val message: String): CourseUIState

}