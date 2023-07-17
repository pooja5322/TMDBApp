package com.example.myapplication.data.model

import com.example.myapplication.domain.model.Movie

data class MoviesDTO(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

