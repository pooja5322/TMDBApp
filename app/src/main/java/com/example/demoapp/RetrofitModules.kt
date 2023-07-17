package com.example.myapplication

import android.content.ContentValues.TAG
import android.util.Log
import com.example.myapplication.common.Constants
import com.example.myapplication.data.remote.MoviesInterface
import com.example.myapplication.data.repository.GetMoviesListImpl
import com.example.myapplication.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModules {

    @Provides
    fun proviesMoviesSearchApi(): MoviesInterface {
        Log.d(TAG, "proviesMoviesSearchApi: ")
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MoviesInterface::class.java)
    }

    @Provides
    fun provideMoviesSearchRepository(moviesInterface: MoviesInterface):SearchRepository{
        return GetMoviesListImpl(moviesInterface)
    }

}