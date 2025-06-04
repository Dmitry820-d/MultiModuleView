package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CourseRepository
): ViewModel() {

    private val _liveDataState = MutableLiveData<Pair<Boolean, String>>()
    val liveDataState: LiveData<Pair<Boolean, String>>
        get() = _liveDataState

    val viewModelScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    fun load(){
        viewModelScope.launch {
            val result = repository.loadNews()
            _liveDataState.postValue(result)
        }
    }

}