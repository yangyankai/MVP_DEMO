package com.example.mvp_demo.model.impl;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mvp_demo.model.WeatherModel;
import com.example.mvp_demo.model.entity.Weather;
import com.example.mvp_demo.present.OnWeatherListener;
import com.example.mvp_demo.util.volley.VolleyRequest;
import com.google.gson.Gson;


/**
 * Created by Administrator on 2015/2/6.
 * 天气Model实现
 */
public class WeatherModelImpl implements WeatherModel {
    @Override
    public void loadWeather(String cityNO, final OnWeatherListener listener) {
        /*数据层操作*/
        VolleyRequest.newInstance().newGsonRequest("http://www.weather.com.cn/data/sk/" + cityNO + ".html",
                Weather.class, new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        if (weather != null) {
                            listener.onSuccess(weather);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }
}