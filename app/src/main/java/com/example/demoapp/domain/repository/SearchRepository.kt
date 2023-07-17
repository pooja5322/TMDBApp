package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.MoviesDTO

interface SearchRepository {
    suspend fun getMoviesList(s1:String,s: String): MoviesDTO
}