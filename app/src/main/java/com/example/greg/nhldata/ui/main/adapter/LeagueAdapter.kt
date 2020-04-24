package com.example.greg.nhldata.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greg.nhldata.R
import com.example.greg.nhldata.ui.main.datamodel.Team
import kotlinx.android.synthetic.main.team_item.view.*

class LeagueAdapter(private val context: Context) : RecyclerView.Adapter<LeagueViewHolder>() {

    var teamsList = emptyList<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.team_item, parent, false)
        return LeagueViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return teamsList.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val team = teamsList[position]
        holder.itemView.team_name.text = context.getString(R.string.team_name_established, team.teamName, team.firstYearOfPlay)
        holder.itemView.team_location.text = team.locationName
        holder.itemView.team_url.text = team.officialSiteUrl
    }
}