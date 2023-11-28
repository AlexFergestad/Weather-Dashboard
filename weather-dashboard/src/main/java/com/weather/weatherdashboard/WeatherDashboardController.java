package com.weather.weatherdashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weather")
public class WeatherDashboardController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherDashboardController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String showSearchForm(Model model) {
        model.addAttribute("search", new Search());
        return "weather";

    }

    @PostMapping("/search")
    public String searchWeather(@ModelAttribute Search search, Model model) {
        if (search.getQuery().isEmpty()) {
            model.addAttribute("error", "City name must not be empty");
            return "weather";
        }
        WeatherInfo weatherInfo = weatherService.getWeatherByCityName(search.getQuery());
        model.addAttribute("weatherInfo", weatherInfo);
        return "weather";
    }

    // Inner class for search
    public static class Search {
        private String query;

        // Getters and setters
        private String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }
    }
}
