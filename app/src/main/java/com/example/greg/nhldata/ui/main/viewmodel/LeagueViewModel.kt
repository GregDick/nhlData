package com.example.greg.nhldata.ui.main.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.greg.nhldata.ui.main.datamodel.Team
import com.example.greg.nhldata.ui.main.repository.Repository

class LeagueViewModel : ViewModel() {

    private val repository = Repository()

    val teams : LiveData<List<Team>> = repository.getTeams()
}
