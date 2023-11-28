package com.weather.weatherdashboard;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    // Mock method to simulate fetching weather data
    // In a real application, you would make a REST call to a weather API
    public WeatherInfo getWeatherByCityName(String cityName) {
        // Mock data
        WeatherInfo mockInfo = new WeatherInfo();
        mockInfo.setCityName(cityName);
        mockInfo.setTemperature(20.0);
        mockInfo.setHumidity(80);
        mockInfo.setWindSpeed(5.5);
        return mockInfo;
    }
}
