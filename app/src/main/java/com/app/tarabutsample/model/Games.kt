package com.app.tarabutsample.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

/**
 * Created by Tarun on 13/08/2021
 */
@Parcelize
data class Games(val gamesItem: List<GamesItem>) : Parcelable

@Parcelize
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
) : Parcelable{
    fun getTeamAScore(): String{
        return score.split("-".toRegex())[0]
    }

    fun getTeamBScore(): String{
        return score.split("-".toRegex())[1]
    }
}