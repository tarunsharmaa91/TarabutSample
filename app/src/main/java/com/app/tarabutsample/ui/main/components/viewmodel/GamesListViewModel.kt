package com.app.tarabutsample.ui.main.components.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tarabutsample.model.GamesItem
import com.app.tarabutsample.repository.GamesListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ApiStatus {
    LOADING,
    ERROR,
    COMPLETED
}

@HiltViewModel
class GamesListViewModel @Inject constructor(gamesListRepository: GamesListRepository) :
    ViewModel() {
    //This is to store the current request status (Internal)
    private val _status = MutableLiveData<ApiStatus>()

    //External Mutable Live Data to store status
    val status: LiveData<ApiStatus>
        get() = _status

    //For result

    private val _results = MutableLiveData<List<GamesItem>>()

    val result: LiveData<List<GamesItem>>
        get() = _results

    //For navigation

    private val _navigateToAdDetail = MutableLiveData<GamesItem>()

    val navigateToAdDetail: LiveData<GamesItem>
        get() = _navigateToAdDetail

    init {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                gamesListRepository.getData().collect {
                    _results.value = it
                }
                _status.value = ApiStatus.COMPLETED
            } catch (ex: Exception) {
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun displayAdDetail(result: GamesItem) {
        _navigateToAdDetail.value = result
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayAdDetailComplete() {
        _navigateToAdDetail.value = null
    }


}


