package ru.anb.hammerapp.api

import retrofit2.Response
import retrofit2.http.GET
import ru.anb.hammerapp.model.MovieModel

interface MovieApi {
    @GET("movielist.json")
    suspend fun registration(): Response<List<MovieModel>>
}