package com.fizz.xiexinwang.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.fizz.xiexinwang.weatherapp.adapter.ForecastListAdapter
import com.fizz.xiexinwang.weatherapp.domain.Forecast
import com.fizz.xiexinwang.weatherapp.domain.log.L
import com.fizz.xiexinwang.weatherapp.domain.RequestForecastCommand
import com.fizz.xiexinwang.weatherapp.listener.OnItemClickListener
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/9",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sta 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        L.init(this.localClassName)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
//        forecastList.adapter = ForecastListAdapter(items)

        async {

            val result = RequestForecastCommand("94043").execute()
            L.i(result.toString())

            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                        object : OnItemClickListener {
                            override fun invoke(forecast: Forecast) {

                                toast(forecast.date)
                            }

                        })
            }
        }

    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }


}
