package com.example.greg.nhldata.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greg.nhldata.ui.main.datamodel.Team
import com.example.greg.nhldata.ui.main.repository.Repository
import com.example.greg.nhldata.ui.main.repository.Repository.Companion.TAG
import kotlinx.coroutines.launch

class LeagueViewModel : ViewModel() {

    private val repository = Repository()
    var loadingState = MutableLiveData<Boolean>()
    var teams = MutableLiveData<List<Team>>()

    init {
        loadingState.postValue(true)
        viewModelScope.launch {
            Log.d(TAG, "inside viewmodel coroutine scope")
            teams.postValue(repository.getLeague().teams)
            loadingState.postValue(false)
        }
    }
}
