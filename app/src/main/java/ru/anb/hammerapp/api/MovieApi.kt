package ru.anb.hammerapp.api

import retrofit2.Response
import retrofit2.http.GET
import ru.anb.hammerapp.model.Model

interface MovieApi {
    @GET("movielist.json")
    suspend fun registration(): Response<List<Model>>
}