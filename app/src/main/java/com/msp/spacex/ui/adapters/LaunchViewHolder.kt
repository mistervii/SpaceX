package com.msp.spacex.ui.adapters

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.msp.spacex.R
import com.msp.spacex.data.model.Launches.LaunchesItem
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.math.absoluteValue

class LaunchViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val missionVal : TextView = view.findViewById(R.id.missionval)
    private val datetimeVal: TextView = view.findViewById(R.id.datetimeval)
    private val rocketVal: TextView = view.findViewById(R.id.rocketval)
    private val timeDiffVal: TextView = view.findViewById(R.id.timediffval)
    private val timeDiffTxtView : TextView = view.findViewById(R.id.timedifftxt)
    private val launchImage : ImageView = view.findViewById(R.id.launche_img)
    private val checkmark : ImageView = view.findViewById(R.id.checkmark)
    private val bottomLine : View = view.findViewById(R.id.bottomLine)
    private val launchLayout : ConstraintLayout = view.findViewById(R.id.launchLayout)
    private val ytbIcon : ImageView = view.findViewById(R.id.ytbIcon)
    private val options = RequestOptions()
                        .dontAnimate()
                        .centerCrop()
                        .placeholder(R.drawable.patch_placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .priority(Priority.HIGH)
    fun bind(context : Context ,launch : LaunchesItem){
        missionVal.text = launch.missionName
        datetimeVal.text = convertTimestampToDate(launch.launchDateUnix)
        rocketVal.text = launch.rocket.rocketName
        val days = calculateDaysDifference(launch.launchDateUnix)

        if (days > 0) {
            timeDiffTxtView.text = String.format(context.getString(R.string.timediff),"since")
        }else{
            timeDiffTxtView.text = String.format(context.getString(R.string.timediff),"from")
        }

        if(launch.launchSuccess == true){
            checkmark.setImageDrawable(context.getDrawable(R.drawable.successcheckmark))
            ViewCompat.setBackgroundTintList(bottomLine, ColorStateList.valueOf(Color.GREEN))
        }else{
            checkmark.setImageDrawable(context.getDrawable(R.drawable.unsuccessfulcheckmark))
            ViewCompat.setBackgroundTintList(bottomLine, ColorStateList.valueOf(Color.RED))
        }


        timeDiffVal.text = days.absoluteValue.toString()


            launch.links.youtubeId?.let { it1 ->
                ytbIcon.visibility = View.VISIBLE
                launchLayout.setOnClickListener {
                    openYoutubeVideo(context, it1)

                }
            }

        Glide.with(context)
            .load(launch.links.missionPatchSmall)
            .thumbnail(0.1f)
            .apply(options)
            .into(launchImage);


    }

    fun convertTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat("dd/MM/yyyy 'at' HH:mm", Locale.getDefault())
        return format.format(date)
    }

    fun calculateDaysDifference(timestamp: Long): Long {
        val instant = Instant.ofEpochSecond(timestamp)
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        val now = LocalDateTime.now()
        return ChronoUnit.DAYS.between(localDateTime, now)
    }

    fun openYoutubeVideo(context: Context,videoId: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))

        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$videoId")
        )

        try {
            context.startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            context.startActivity(webIntent)
        }
    }
}