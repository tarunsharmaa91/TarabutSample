package com.app.tarabutsample.model

import com.squareup.moshi.Json

/**
 * Created by Tarun on 13/08/2021
 */
class Games : ArrayList<GamesItem>()

data class GamesItem(
    @Json(name = "Date")
    val date: String,
    @Json(name = "Score")
    val score: String,
    @Json(name = "Team_A")
    val teamA: String,
    @Json(name = "Team_B")
    val teamB: String,
    @Json(name = "link_A")
    val linkA: String,
    @Json(name = "link_B")
    val linkB: String
)