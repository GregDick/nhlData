package com.example.greg.nhldata.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.greg.nhldata.ui.main.datamodel.Team

class LeagueViewModel : ViewModel() {

    private val teams: MutableLiveData<List<Team>> by lazy {
        MutableLiveData<List<Team>>().also {
            loadTeams()
        }
    }

    fun getTeams() : LiveData<List<Team>> {
        return teams
    }

    private fun loadTeams() {
        val teamList = mutableListOf<Team>()
        teams.value = teamList
    }
}
