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

//for an image - https://image.tmdb.org/t/p/w500/jIsKmkxMzdCZ0Ux1GVSnu8m6Na6.jpg
//for movie name - https://api.themoviedb.org/3/search/movie?api_key=2ed5dd1c48f6cf11ad1d7e0fb1703447&query=kantara
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val handler = Handler()
    lateinit var tmdb_txt:TextView
    lateinit var tmdb_str:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tmdb_txt.text=tmdb_str
        /*if(this::tmdb_txt.isInitialized){
            Toast.makeText(this@MainActivity,"hi",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@MainActivity,"no",Toast.LENGTH_LONG).show()
        }*/
        supportActionBar?.hide()
       /* handler.postDelayed({
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 500)*/
    }

}

