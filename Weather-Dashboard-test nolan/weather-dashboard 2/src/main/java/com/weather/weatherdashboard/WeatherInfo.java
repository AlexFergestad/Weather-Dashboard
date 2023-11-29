package com.weather.weatherdashboard;

import java.time.ZonedDateTime;

public class WeatherInfo {
    private String cityName;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private String sky;
    private int uvIndex;
    private ZonedDateTime sunSet;

    public WeatherInfo() {

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public ZonedDateTime getSunSet() {
        return sunSet;
    }

    public void setSunSet(ZonedDateTime sunSet) {
        this.sunSet = sunSet;
    }

}