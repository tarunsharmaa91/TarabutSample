package com.app.blog.network

import com.app.tarabutsample.model.GamesItem
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }

    @GET("23745f3a-5eaa-43cf-ab46-737eb273596b")
    suspend fun getUpcomingGames(): List<GamesItem>

    @GET("bc1ce3b7-6ad2-4fef-af6c-08f8865b210e")
    suspend fun getMoreUpcomingGames(): List<GamesItem>

}