package com.example.greg.nhldata.ui.main.network

import com.example.greg.nhldata.ui.main.datamodel.League
import com.example.greg.nhldata.ui.main.datamodel.Roster
import retrofit2.http.GET
import retrofit2.http.Path

interface NhlApiService {
    @GET("teams")
    suspend fun getTeams(): League

    @GET("teams/{id}/roster")
    suspend fun getRoster(@Path("id") id : String): Roster
}