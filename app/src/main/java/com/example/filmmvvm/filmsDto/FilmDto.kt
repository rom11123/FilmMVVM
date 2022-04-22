package com.example.filmmvvm.filmsDto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmDto(
    @SerializedName("id")
    val id : Int?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("release")
    val release : String?,
    @SerializedName("playtime")
    val playtime : String?,
    @SerializedName("description")
    val description : String?,
    @SerializedName("plot")
    val plot : String?,
    @SerializedName("poster")
    val poster : String?,
):Serializable
