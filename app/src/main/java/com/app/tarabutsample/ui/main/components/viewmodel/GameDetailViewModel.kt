package com.app.blog.ui.component.post_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.blog.network.ApiService
import com.app.tarabutsample.model.GamesItem

class GameDetailViewModel constructor(
    gamesItem: GamesItem,
) :
    ViewModel() {

    private val _selectedAdDetail = MutableLiveData<GamesItem>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<GamesItem>
        get() = _selectedAdDetail

    init {
        _selectedAdDetail.value = gamesItem
    }

}