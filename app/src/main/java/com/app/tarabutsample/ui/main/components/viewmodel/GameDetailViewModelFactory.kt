package com.app.blog.ui.component.post_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.blog.network.ApiService
import com.app.tarabutsample.model.GamesItem

class GameDetailViewModelFactory(
    private val game: GamesItem,

) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameDetailViewModel::class.java)) {
            return GameDetailViewModel(game) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}