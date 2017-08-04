package com.fizz.xiexinwang.weatherapp.domain

/**
 * Created by xiexinwang on 2017/6/28.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)