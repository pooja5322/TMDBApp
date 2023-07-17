package com.example.myapplication.data.remote

import com.example.myapplication.data.model.MoviesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesInterface {
    //api_key=2ed5dd1c48f6cf11ad1d7e0fb1703447&
    @GET("3/search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MoviesDTO
}