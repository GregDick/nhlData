package com.example.greg.nhldata.ui.main.network

import com.example.greg.nhldata.ui.main.datamodel.Team
import retrofit2.Call
import retrofit2.http.GET

interface NhlApiService {
    @GET("teams")
    fun getTeams() : Call<List<Team>>

}