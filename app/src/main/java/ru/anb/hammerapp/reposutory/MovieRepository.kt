package ru.anb.hammerapp.reposutory

import android.util.Log
import ru.anb.hammerapp.LoadState
import ru.anb.hammerapp.R
import ru.anb.hammerapp.api.MovieApi
import ru.anb.hammerapp.model.Model
import javax.inject.Inject

class MovieRepository @Inject constructor(private val authApi: MovieApi) {

    suspend fun getMovies(): LoadState <List<Model>> {
        val result = authApi.registration()
        return if (result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }
}