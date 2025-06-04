package com.example.data

import com.example.data.models.CoursesDTO
import retrofit2.http.GET
import retrofit2.http.Query


//https://official-joke-api.appspot.com/random_joke
//https://api.ipify.org/?format=json
//https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download

interface CourseApi {
//   ("/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    @GET("/u/0/uc")
    suspend fun getNews(
        @Query("id") id: String = "15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q",
        @Query("export") export: String = "download",
    ): CoursesDTO
}


//"id": 100,
//"title": "Java-разработчик с нуля",
//"text": "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
//"price": "999",
//"rate": "4.9",
//"startDate": "2024-05-22",
//"hasLike": false,
//"publishDate": "2024-02-02"
//},





