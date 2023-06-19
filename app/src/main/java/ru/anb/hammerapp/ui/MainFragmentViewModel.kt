package ru.anb.hammerapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.hammerapp.LoadState
import ru.anb.hammerapp.model.Model
import ru.anb.hammerapp.reposutory.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    private val _authState = MutableStateFlow<LoadState<List<Model>>>(LoadState.Loading())
    val authState get() = _authState.asStateFlow()

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            val result = repository.getMovies()
            _authState.value = result
        }
    }
}
