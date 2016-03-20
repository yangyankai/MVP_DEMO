package com.example.mvp_demo.model;

import com.example.mvp_demo.present.OnWeatherListener;

/**
 * Created by Administrator on 2015/2/6.
 * 天气Model接口
 */
public interface WeatherModel {
    void loadWeather(String cityNO, OnWeatherListener listener);
}