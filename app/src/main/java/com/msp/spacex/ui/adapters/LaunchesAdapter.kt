package com.msp.spacex.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.msp.spacex.R
import com.msp.spacex.data.model.Launches.LaunchesItem

class LaunchesAdapter : RecyclerView.Adapter<LaunchViewHolder>() {
    var launches : List<LaunchesItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.launches_item,parent,false)
        return  LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(launches[position])
    }
    override fun getItemCount(): Int = launches.size
}