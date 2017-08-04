package com.fizz.xiexinwang.weatherapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fizz.xiexinwang.weatherapp.R
import com.fizz.xiexinwang.weatherapp.domain.Forecast
import com.fizz.xiexinwang.weatherapp.domain.ForecastList
import com.fizz.xiexinwang.weatherapp.listener.OnItemClickListener
import com.fizz.xiexinwang.weatherapp.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by xiexinwang on 2017/6/28.
 */
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: OnItemClickListener) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.ctx)
                .inflate(R.layout.item_forceast, parent, false)

        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    class ViewHolder(val view: View, val itemClick: OnItemClickListener) :
            RecyclerView.ViewHolder(view) {

        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }


}