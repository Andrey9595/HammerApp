package ru.anb.hammerapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.anb.hammerapp.LoadState
import ru.anb.hammerapp.adapter.MovieAdapter
import ru.anb.hammerapp.adapter.TagAdapter
import ru.anb.hammerapp.adapter.TestData
import ru.anb.hammerapp.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get()  = _binding!!
    private val viewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieAdapter = MovieAdapter()
        binding.recyclerView.adapter = movieAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.authState.collect {

                    if (it is LoadState.Success) {
//                        Log.d("movie", "${it.data}")
                        val list = mutableListOf<Any>(TestData.bannerList, TestData.tagList)
                        list.addAll(it.data!!)
                        movieAdapter.setMovies(list)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}