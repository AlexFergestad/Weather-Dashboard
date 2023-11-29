package com.weather.weatherdashboard;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
public class WeatherDashboardController {

        private final WeatherService weatherService;

    
    public WeatherDashboardController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String getWeatherInfo(@RequestParam String city, Model model) throws Exception {
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(city);
        model.addAttribute("weatherInfo", weatherInfo);
        return "index";
    }

}
