package com.fizz.xiexinwang.weatherapp.domain

/**
 * Created by xiexinwang on 2017/6/28.
 */
interface Command<T> {
    fun execute(): T
}