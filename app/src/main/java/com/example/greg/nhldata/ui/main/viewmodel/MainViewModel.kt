package com.example.greg.nhldata.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greg.nhldata.ui.main.datamodel.Player
import com.example.greg.nhldata.ui.main.datamodel.Team
import com.example.greg.nhldata.ui.main.repository.Repository
import com.example.greg.nhldata.ui.main.repository.Repository.Companion.TAG
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val repository: Repository
) : ViewModel() {

    var loadingState = MutableLiveData<Boolean>()
    var teams = MutableLiveData<List<Team>>()
    var roster = MutableLiveData<List<Player>>()

    init {
        loadingState.postValue(true)
        viewModelScope.launch {
            Log.d(TAG, "viewmodel coroutine scope fetch league")
            teams.postValue(repository.getLeague().teams)
            loadingState.postValue(false)
        }
    }

    fun fetchRoster(teamId: String) {
        viewModelScope.launch {
            Log.d(TAG, "viewmodel coroutine scope fetch roster")
            roster.postValue(repository.getRoster(teamId).roster)
        }
    }
}
