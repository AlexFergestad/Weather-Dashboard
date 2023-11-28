package com.example.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
   private final String apiKey = "0fabcc4be3dfbcc64b13954252176305";
   private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";

   public WeatherService() {
   }

   public WeatherInfo getWeather(String city) {
      String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=0fabcc4be3dfbcc64b13954252176305&units=metric";
      RestTemplate restTemplate = new RestTemplate();
      OpenWeatherMapResponse response = (OpenWeatherMapResponse)restTemplate.getForObject(url, OpenWeatherMapResponse.class, new Object[0]);
      return response != null ? this.mapToWeatherInfo(response) : null;
   }

   private WeatherInfo mapToWeatherInfo(OpenWeatherMapResponse response) {
      return new WeatherInfo(response.getName(), response.getMain().getTemp(), response.getMain().getHumidity());
   }
}
