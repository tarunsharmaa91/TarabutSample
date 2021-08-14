package com.app.tarabutsample.ui.main.components.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.blog.ui.component.post_detail.GameDetailViewModel
import com.app.blog.ui.component.post_detail.GameDetailViewModelFactory
import com.app.tarabutsample.databinding.GameDetailFragmentBinding

class GameDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = GameDetailFragmentBinding.inflate(inflater)

        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this

        binding.fragment = this

        val gameData = GameDetailArgs.fromBundle(requireArguments()).selectedGame

        val viewModelFactory = GameDetailViewModelFactory(gameData)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(GameDetailViewModel::class.java)
        return binding.root
    }

    fun onBack() {
        this.findNavController().popBackStack()
    }

}