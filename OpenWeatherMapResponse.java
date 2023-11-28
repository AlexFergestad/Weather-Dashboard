package com.example.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
   ignoreUnknown = true
)
public class OpenWeatherMapResponse {
   @JsonProperty("main")
   private Main main;
   @JsonProperty("name")
   private String cityName;

   public OpenWeatherMapResponse() {
   }

   public Main getMain() {
      return this.main;
   }

   public String getName() {
      return this.cityName;
   }

   public String toString() {
      String var10000 = String.valueOf(this.main);
      return "OpenWeatherMapResponse{main=" + var10000 + ", cityName='" + this.cityName + "'}";
   }
}
