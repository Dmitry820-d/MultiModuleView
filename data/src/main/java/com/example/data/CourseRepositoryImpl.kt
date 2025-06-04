package com.example.data

import com.example.domain.CourseRepository
import com.example.domain.LoadCourseResult
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val api: CourseApi
): CourseRepository {



    override suspend fun loadNews(): LoadCourseResult {
        //val format = "json"
        return try {
            val coursesDTO = api.getNews()
            val coursesDomain = coursesDTO.mapToCoursesDomain()
            LoadCourseResult.Success(courses = coursesDomain)
        } catch (e: Exception){
            println("ERROR             ${e.message}")
            LoadCourseResult.Error(message =  e.message ?: "error load news from repository")
        }
    }
}



fun formatDateToString(date: Date): String {
    // Преобразуем java.util.Date в millis of epoch
    val instant = Instant.fromEpochMilliseconds(date.time)

    // Приводим к локальному представлению даты (без времени суток)
    val localDateTimeUtc = instant.toLocalDateTime(TimeZone.UTC)

    return localDateTimeUtc.date.toString()
}


