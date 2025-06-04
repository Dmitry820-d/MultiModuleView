package com.example.multimoduleview

import android.os.Build
import com.example.data.CourseApi
import com.example.data.CourseRepositoryImpl
import com.example.domain.CourseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
interface MainModule {
    companion object {
        @Provides
        fun provideRetrofit() : Retrofit {

            val baseUrl = BuildConfig.BASE_URL

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        @Provides
        fun provideCourseApi(retrofit: Retrofit): CourseApi {
            return retrofit.create(CourseApi::class.java)
        }

    }

    @Binds
    fun bindCourseRepositoryImpl(courseRepositoryImpl: CourseRepositoryImpl) : CourseRepository
}
