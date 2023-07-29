package com.msp.spacex.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.msp.spacex.R
import com.msp.spacex.data.model.Launches.LaunchesItem

class LaunchViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val missionVal : TextView = view.findViewById(R.id.missionval)
    private val datetimeVal: TextView = view.findViewById(R.id.datetimeval)
    private val rocketVal: TextView = view.findViewById(R.id.rocketval)
    private val timeDiffVal: TextView = view.findViewById(R.id.timediffval)
    private val launchImage : ImageView = view.findViewById(R.id.launche_img)

    fun bind(launch : LaunchesItem){
        missionVal.text = launch.missionName
        datetimeVal.text = launch.launchDateLocal
        rocketVal.text = launch.rocket.rocketName
        timeDiffVal.text = "date Diff"
    }
}