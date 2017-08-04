package com.fizz.xiexinwang.weatherapp.domain

import com.fizz.xiexinwang.weatherapp.utils.ForecastRequset

/**
 * Created by xiexinwang on 2017/6/28.
 */
class RequestForecastCommand(val zipCode:String):
        Command<ForecastList>{
    override fun execute(): ForecastList {

        val forecastRequest = ForecastRequset(zipCode)
        return ForecastDataMapper().converFromDataModel(
                forecastRequest.execute())
    }

}