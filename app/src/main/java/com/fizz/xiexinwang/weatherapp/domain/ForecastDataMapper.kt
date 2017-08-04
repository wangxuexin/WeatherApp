package com.fizz.xiexinwang.weatherapp.domain

import com.fizz.xiexinwang.weatherapp.data.ForecastResult
import com.fizz.xiexinwang.weatherapp.data.Forecast
import com.fizz.xiexinwang.weatherapp.domain.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by xiexinwang on 2017/6/28.
 */
class ForecastDataMapper{
    fun converFromDataModel(forecast: ForecastResult): ForecastList {

        return ForecastList(forecast.city.name,forecast.city.country,
                converForecastListDomain(forecast.list))

    }

    private fun converForecastListDomain(list: List<Forecast>):
    List<ModelForecast>{
        return list.map{
            converForecastItemDomain(it)
        }

    }

    private fun converForecastItemDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(converData(forecast.dt),
                forecast.weather[0].description,forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))


    }

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"

    private fun converData(data: Long): String {

        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(data*1000)
    }
}