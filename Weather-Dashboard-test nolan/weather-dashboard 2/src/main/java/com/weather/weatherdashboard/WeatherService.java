package com.weather.weatherdashboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

    private final String apiKey = "0fabcc4be3dfbcc64b13954252176305";
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";

    public WeatherInfo getWeatherInfo(String city) throws Exception {
        String apiUrl = baseUrl + "?q=" + city + "&appid=" + apiKey + "&units=Imperial";
        String apiResponse = sendHttpRequest(apiUrl);
        WeatherInfo weatherInfo = convertJsonToWeatherInfo(apiResponse);

        if (weatherInfo != null) {
            return weatherInfo;
        } else {
            return null; // Handle error or return default WeatherInfo
        }
    }

    private static WeatherInfo convertJsonToWeatherInfo(String apiResponse) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(apiResponse);
        char degreesSymbol = '\u00B0';
        
        // Map JSON nodes to WeatherInfo fields
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setCityName(rootNode.path("name").asText());
        weatherInfo.setTemperature(rootNode.path("main").path("temp").asText()+ degreesSymbol + "F");
        weatherInfo.setHumidity(rootNode.path("main").path("humidity").asText() + "%");
        weatherInfo.setWindSpeed(rootNode.path("wind").path("speed").asText() + " mph");
        weatherInfo.setSky(rootNode.path("weather").get(0).path("main").asText());
        weatherInfo.setSunSet(convertUtcToSystemDateTime(rootNode.path("sys").path("sunset").asLong()).toLocalTime().toString());

        return weatherInfo;
    }

    private static String sendHttpRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            // Set up HTTP connection
            connection.setRequestMethod("GET");

            // Get the response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                return response.toString();
            }
        } finally {
            // Disconnect to release resources
            connection.disconnect();
        }
    }

    private static ZonedDateTime convertUtcToSystemDateTime(long utcTimestamp) {
        Instant instant = Instant.ofEpochSecond(utcTimestamp);
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
