package com.example.greg.nhldata.ui.main.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.greg.nhldata.ui.main.datamodel.League
import com.example.greg.nhldata.ui.main.datamodel.Roster
import com.example.greg.nhldata.ui.main.datamodel.Team
import com.example.greg.nhldata.ui.main.network.NhlApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject


class Repository @Inject constructor() {

    @Inject
    lateinit var service: NhlApiService

    suspend fun getLeague(): League {
        Log.d(TAG, "Repository get league")
        return service.getTeams()
    }

    suspend fun getRoster(id: String): Roster {
        Log.d(TAG, "Repository get roster for: $id")
        return service.getRoster(id)
    }

    companion object {
        const val BASE_URL = "https://statsapi.web.nhl.com/api/v1/"
        const val TAG = "NETWORKING"
    }
}