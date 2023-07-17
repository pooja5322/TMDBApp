package com.example.demoapp.presenter.HomeScreen

import com.example.myapplication.domain.model.Movie

data class MoviesSearchState(
    val data : List<Movie>?=null,
    val error: String="",
    val isLoading:Boolean=false
) {
}