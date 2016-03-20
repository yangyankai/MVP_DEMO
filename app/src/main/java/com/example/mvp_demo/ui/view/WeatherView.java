package com.example.mvp_demo.ui.view;

import com.example.mvp_demo.model.entity.Weather;

/**
 * Created by Administrator on 2015/2/7.
 */
public interface WeatherView {
    void showLoading();

    void hideLoading();

    void showError();

    void setWeatherInfo(Weather weather);
}