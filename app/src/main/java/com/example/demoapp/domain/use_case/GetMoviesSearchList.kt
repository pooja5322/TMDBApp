package com.example.myapplication.domain.use_case

import com.bumptech.glide.load.engine.Resource
import com.example.myapplication.common.Constants
import com.example.myapplication.common.NetworkResult
import com.example.myapplication.data.model.toDomainMovie
import com.example.myapplication.domain.model.Movie
import com.example.myapplication.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception

import javax.inject.Inject

class GetMoviesSearchList @Inject constructor(private val repository: SearchRepository) {


    operator fun invoke(s: String): Flow<NetworkResult<List<Movie>>> = flow {
        try {
            emit(NetworkResult.Loading())
            val resposne = repository.getMoviesList(Constants.API_KEY,s)

            val list =
                if (resposne.results.isNullOrEmpty()) emptyList<Movie>() else resposne.results.map { it.toDomainMovie() }

            emit(NetworkResult.Success(data = list))
        } catch (e: IOException) {
            emit(
                NetworkResult.Error(
                    message = e.localizedMessage ?: "Check your internet connection"
                )
            )

        } catch (e: Exception) {
            emit(NetworkResult.Error(message = e.localizedMessage ?: "Unknown Error"))
        }
    }
}