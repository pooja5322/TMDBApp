package com.example.demoapp.presenter.HomeScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.NetworkResult
import com.example.myapplication.domain.use_case.GetMoviesSearchList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesSearchList: GetMoviesSearchList):ViewModel() {
    private val _moviesSearchList = MutableStateFlow<MoviesSearchState>(MoviesSearchState())
    val moviesSearchList:StateFlow<MoviesSearchState> = _moviesSearchList

    private val _query : MutableLiveData<String> = MutableLiveData()

    fun searchMovieList(s:String){
        getMoviesSearchList(s).onEach {
            when(it){
                is NetworkResult.Loading->{
                    _moviesSearchList.value= MoviesSearchState(isLoading = true)
                }
                is NetworkResult.Error -> {
                    _moviesSearchList.value= MoviesSearchState(error = it.message?:"")
                }
                is NetworkResult.Success -> {
                    _moviesSearchList.value= MoviesSearchState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


}