package com.example.greg.nhldata.ui.main.callback

interface LeagueFragmentCallback {
    fun fetchRoster(teamId: String)
    fun navigateToRosterFragment()
}