package com.example.greg.nhldata.ui.main.datamodel

import com.squareup.moshi.Json

data class League(
    val copyright: String,
    val teams: List<Team>
)