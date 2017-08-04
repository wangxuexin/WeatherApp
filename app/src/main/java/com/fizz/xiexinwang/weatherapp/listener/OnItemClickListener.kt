package com.fizz.xiexinwang.weatherapp.listener

import com.fizz.xiexinwang.weatherapp.domain.Forecast

/**
 * Created by xiexinwang on 2017/6/28.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}