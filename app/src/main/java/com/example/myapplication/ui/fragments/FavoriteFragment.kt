package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFavoriteBinding
import com.example.myapplication.ui.viewpager.MoviesCollectionAdapter
import com.example.myapplication.utils.hideAnimated
import com.example.myapplication.utils.showAnimated
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieCollectionAdapter: MoviesCollectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showProgress(true)
        movieCollectionAdapter = MoviesCollectionAdapter(
            childFragmentManager,
            lifecycle
        )
        binding.pager.adapter = movieCollectionAdapter
        binding.pager.offscreenPageLimit  = 2
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = when(position) {
                0 -> "Любимые фильмы"
                1 -> "Любимые сериалы"
                2 -> "Watchlist фильмов"
                3 -> "Watchlist сериалов"
                else -> ""
            }
        }.attach()
        showProgress(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showProgress(show: Boolean) {
        if (show) {
            binding.apply {
                loaded.hideAnimated()
                loading.showAnimated()
            }
        } else {
            binding.apply {
                loaded.showAnimated()
                loading.hideAnimated()
            }
        }
    }

}