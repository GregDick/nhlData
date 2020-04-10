package com.example.greg.nhldata.ui.main.repository

import com.example.greg.nhldata.ui.main.network.NhlApiService
import retrofit2.Retrofit




class Repository {

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    var service: NhlApiService = retrofit.create<NhlApiService>(NhlApiService::class.java)


    companion object {
        const val BASE_URL = "https://statsapi.web.nhl.com/api/v1"
    }
}