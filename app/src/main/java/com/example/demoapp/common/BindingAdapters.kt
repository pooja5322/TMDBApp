package com.example.myapplication.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.demoapp.R

@BindingAdapter("urlToImage")
fun urlToImage(view:ImageView, str:String){
    val options = RequestOptions.placeholderOf(R.drawable.loading).error(R.drawable.error)
    Glide.with(view).setDefaultRequestOptions(options).load("https://image.tmdb.org/t/p/w500${str}").into(view)
}