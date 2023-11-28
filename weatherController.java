package com.example.weather;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeatherInfo(@RequestParam String city, Model model) {
        WeatherInfo weatherInfo = weatherService.getWeather(city);
        model.addAttribute("weatherInfo", weatherInfo);
        return "weather";
    }
}
