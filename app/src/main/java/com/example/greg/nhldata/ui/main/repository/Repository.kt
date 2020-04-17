package com.example.greg.nhldata.ui.main.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.greg.nhldata.ui.main.datamodel.League
import com.example.greg.nhldata.ui.main.datamodel.Team
import com.example.greg.nhldata.ui.main.network.NhlApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class Repository {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    var service: NhlApiService = retrofit.create<NhlApiService>(NhlApiService::class.java)

    fun getTeams() : MutableLiveData<List<Team>>{
        val liveData = MutableLiveData<List<Team>>()
        val teamList = mutableListOf<Team>()

        service.getTeams().enqueue(object: Callback<League> {

            override fun onFailure(call: Call<League>, t: Throwable) {
                Log.d(TAG, "error: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<League>, response: Response<League>) {
                val jsonAdapter = moshi.adapter(League::class.java)
                if(response.isSuccessful) {
                    Log.d(TAG, "response body: ${response.body()}")
                    val league = response.body()
                    league?.teams?.forEach {
                        Log.d(TAG, "team: $it")
                        teamList.add(it)
                    }
                    liveData.value = teamList
                }
            }
        })

        return liveData
    }


    companion object {
        const val BASE_URL = "https://statsapi.web.nhl.com/api/v1/"
        const val TAG = "NETWORKING"
    }
}