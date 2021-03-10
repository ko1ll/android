package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation

class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {
    private val players: MutableList<ProPlayerResponse> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_cat,parent,false)
        return PlayerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position],position)
    }

    override fun getItemCount() = players.size

    fun addPlayers(newPlayers: List<ProPlayerResponse>){
        players += newPlayers
        notifyDataSetChanged()
    }

    fun clearPlayers(){
        players.clear()
        notifyDataSetChanged()
    }

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.avatar)
        private val person_name: TextView = itemView.findViewById(R.id.person_name)
        private val btm: Button = itemView.findViewById(R.id.btm)
        fun bind(player: ProPlayerResponse, position: Int){
            person_name.text = player.person_name
            btm.setOnClickListener{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(player.profile_url));
                startActivity(itemView.context,browserIntent, Bundle())
            }
            avatar.load(player.avatar){
                crossfade(true)
                placeholder(R.mipmap.ic_launcher)
                transformations(CircleCropTransformation())
            }
        }
    }
}