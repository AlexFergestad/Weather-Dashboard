package com.weather.weatherdashboard;

public class WeatherInfo {
    private String cityName;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String sky;
    private int uvIndex;
    private double sunSet;
    
    public WeatherInfo(String cityName, double temperature, int humidity, double windSpeed, String sky, int uvIndex, double sunSet) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.sky = sky;
        this.uvIndex = uvIndex;
        this.sunSet = sunSet;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(double windSpeed) {
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
    public double getSunSet() {
        return sunSet;
    }
    public void setSunSet(double sunSet) {
        this.sunSet = sunSet;
    }
    
}
