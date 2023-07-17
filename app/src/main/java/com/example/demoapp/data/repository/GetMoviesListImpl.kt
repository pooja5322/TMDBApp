package com.example.myapplication.data.repository

import com.example.myapplication.data.model.MoviesDTO
import com.example.myapplication.data.remote.MoviesInterface
import com.example.myapplication.domain.repository.SearchRepository

class GetMoviesListImpl(private val moviesInterface: MoviesInterface) :SearchRepository{

    override suspend fun getMoviesList(s1:String,s: String): MoviesDTO {
        return moviesInterface.searchMovies(s1,s)
    }
}