package com.example.filmmvvm.repositories

import com.example.filmmvvm.filmsDto.FilmDto
import com.example.filmmvvm.net.api.Retrofit
import retrofit2.Call

class Repository {
    fun getFilmRepo():Call<List<FilmDto>>{
        return Retrofit.createApiService().getFilmDto()
    }
}