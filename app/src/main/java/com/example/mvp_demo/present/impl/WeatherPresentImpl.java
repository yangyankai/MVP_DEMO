package com.example.mvp_demo.present.impl;


import com.example.mvp_demo.model.WeatherModel;
import com.example.mvp_demo.model.entity.Weather;
import com.example.mvp_demo.model.impl.WeatherModelImpl;
import com.example.mvp_demo.present.OnWeatherListener;
import com.example.mvp_demo.present.WeatherPresenter;
import com.example.mvp_demo.ui.view.WeatherView;

/**
 * Created by Administrator on 2015/2/6.
 * 天气 Prestener实现
 */
public class WeatherPresentImpl implements WeatherPresenter, OnWeatherListener {
    /*Presenter作为中间层，持有View和Model的引用*/
    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresentImpl(WeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel = new WeatherModelImpl();
    }

    @Override
    public void getWeather(String cityNO) {
        weatherView.showLoading();
        weatherModel.loadWeather(cityNO, this);
    }

    @Override
    public void onSuccess(Weather weather) {
        weatherView.hideLoading();
        weatherView.setWeatherInfo(weather);
    }

    @Override
    public void onError() {
        weatherView.hideLoading();
        weatherView.showError();
    }
}