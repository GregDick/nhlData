package com.example.greg.nhldata.ui.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greg.nhldata.R
import com.example.greg.nhldata.ui.main.datamodel.Player
import kotlinx.android.synthetic.main.player_item.view.*

class RosterAdapter(private val context: Context) : RecyclerView.Adapter<RosterViewHolder>(){

    var playerList = emptyList<Player>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.player_item, parent, false)
        return RosterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: RosterViewHolder, position: Int) {
        val player = playerList[position]
        Log.v("roster adapter", "player: $player")
        holder.itemView.player_number.text = context.getString(R.string.player_number, player.jerseyNumber)
        holder.itemView.player_name.text = player.person.fullName
        holder.itemView.player_pos.text = player.position.name
    }

}
