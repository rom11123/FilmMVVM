package com.example.filmmvvm.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmmvvm.filmsDto.FilmDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentViewModel:ViewModel() {
 private  val _liveData:MutableLiveData<List<FilmDto>> = MutableLiveData()
    val liveData:LiveData<List<FilmDto>>
    get() = _liveData
    private var repository = Repository()

    fun getFilm(){
        repository.getFilmRepo().enqueue(object :Callback<List<FilmDto>>{
            override fun onResponse(call: Call<List<FilmDto>>, response: Response<List<FilmDto>>) {
                _liveData.value= response.body()
            }

            override fun onFailure(call: Call<List<FilmDto>>, t: Throwable) {
                Log.d("Tag","error")

            }
        })
    }
}