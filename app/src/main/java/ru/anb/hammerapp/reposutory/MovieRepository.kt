package ru.anb.hammerapp.reposutory

import ru.anb.hammerapp.LoadState
import ru.anb.hammerapp.R
import ru.anb.hammerapp.api.MovieApi
import ru.anb.hammerapp.model.Model
import javax.inject.Inject

class MovieRepository @Inject constructor(private val authApi: MovieApi) {

    suspend fun sendPhone(request: List<Model>): LoadState.Success<List<Model>> {
        val result = authApi.registration(request)
        return if (result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }
}