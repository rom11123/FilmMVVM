package com.example.filmmvvm.net.api

import com.example.filmmvvm.filmsDto.FilmDto
import com.example.filmmvvm.net.Constants.Companion.END_POINT
import retrofit2.Call
import retrofit2.http.GET

interface FilmApiService {
    @GET(END_POINT)
    fun getFilmDto():Call<List<FilmDto>>

}