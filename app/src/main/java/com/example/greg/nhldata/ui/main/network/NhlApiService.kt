package com.example.greg.nhldata.ui.main.network

import com.example.greg.nhldata.ui.main.datamodel.League
import retrofit2.http.GET

interface NhlApiService {
    @GET("teams")
    suspend fun getTeams(): League
}