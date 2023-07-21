package com.example.demoapp.presenter.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.R
import com.example.demoapp.presenter.HomeScreen.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

//for an image - https://image.tmdb.org/t/p/w500/deo.jpg
//for movie name - https://api.themoviedb.org/3/search/movie?api_key=API_KEY&query=kantara
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        handler.postDelayed({
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}

