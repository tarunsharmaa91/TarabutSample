package com.app.tarabutsample.repository

import com.app.blog.network.ApiService
import com.app.blog.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GamesListRepository @Inject constructor(
    private val apiService: ApiService,
) : Repository {

    fun getData() = flow {
        emit(apiService.getUpcomingGames())
    }.flowOn(Dispatchers.IO)

    fun getMoreData() = flow {
        emit(apiService.getMoreUpcomingGames())
    }.flowOn(Dispatchers.IO)

}
