package com.example.filmmvvm.net.api

import com.example.filmmvvm.net.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private var retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    fun createApiService(): FilmApiService = retrofit.create(FilmApiService::class.java)
}