package ru.anb.hammerapp.reposutory

import ru.anb.hammerapp.LoadState
import ru.anb.hammerapp.R
import ru.anb.hammerapp.api.MovieApi
import ru.anb.hammerapp.model.MovieModel
import javax.inject.Inject

class MovieRepository @Inject constructor(private val authApi: MovieApi) {

    suspend fun getMovies(): LoadState <List<MovieModel>> {
        val result = authApi.registration()
        return if (result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }
}