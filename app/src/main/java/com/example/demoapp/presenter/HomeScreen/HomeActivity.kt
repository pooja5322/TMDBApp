package com.example.demoapp.presenter.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.coroutineScope
import com.example.demoapp.R
import com.example.demoapp.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding? = null
    private val movieSearchAdapter = MovieSearchAdapter()
    val binding: ActivityHomeBinding
        get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        supportActionBar?.hide()
        binding.serachmovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    homeViewModel.searchMovieList(it)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })

        binding.recyclerview.apply {
            adapter = movieSearchAdapter
        }

        lifecycle.coroutineScope.launchWhenCreated {
            homeViewModel.moviesSearchList.collect() {
                if (it.isLoading) {
                    //loading
                }
                if (it.error.isNotBlank()) {
                    //loading gone
                }
                it.data?.let {
                    movieSearchAdapter.setContentList(it.toMutableList())
                }
            }
        }
    }
}