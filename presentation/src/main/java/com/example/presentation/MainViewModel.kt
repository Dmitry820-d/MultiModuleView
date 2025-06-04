package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.CourseRepository
import com.example.domain.LoadCourseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CourseRepository,
    private val courseMapper: LoadCourseResult.Mapper<CourseUIState>
): ViewModel() {

    private val _liveDataState = MutableLiveData<CourseUIState>()
    val liveDataState: LiveData<CourseUIState>
        get() = _liveDataState

    val viewModelScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    fun load(){
        viewModelScope.launch {
            val loadCourseResult = repository.loadNews()
            val courseUIState = loadCourseResult.map(courseMapper)
            _liveDataState.postValue(courseUIState)
        }
    }

}