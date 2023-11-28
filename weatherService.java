package com.example.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final String apiKey = "0fabcc4be3dfbcc64b13954252176305";
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";

    public WeatherInfo getWeather(String city) {
        String url = baseUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        OpenWeatherMapResponse response = restTemplate.getForObject(url, OpenWeatherMapResponse.class);

        if (response != null) {
            return mapToWeatherInfo(response);
        } else {
            return null; // Handle error or return default WeatherInfo
        }
    }

    private WeatherInfo mapToWeatherInfo(OpenWeatherMapResponse response) {
        return new WeatherInfo(
            response.getName(),
            response.getMain().getTemp(),
            response.getMain().getHumidity(),
            response.getWind().getSpeed(),
            response.getWeather().get(0).getDescription(),
            response.getUvi(),
            response.getSys().getSunset()
        );
    }
}
