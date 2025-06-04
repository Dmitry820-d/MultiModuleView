package com.example.data

import com.example.domain.CourseRepository
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



    override suspend fun loadNews(): Pair<Boolean, String> {
        //val format = "json"
        return try {
            val courses = api.getNews()
            var result = ""
            courses.courses.forEach {
                result += it
                result += "\n"
                result += "\n"
                println("dateDate = ${formatDateToString(it.startDate)}")
            }
            Pair(true, result)
        } catch (e: Exception){
            println("ERROR             ${e.message}")
            Pair(false, e.message ?: "error load news from repository")
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


