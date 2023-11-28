package com.example.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherMapResponse$Main {
   @JsonProperty("temp")
   private double temperature;
   @JsonProperty("humidity")
   private int humidity;

   public OpenWeatherMapResponse$Main() {
   }

   public double getTemp() {
      return this.temperature;
   }

   public int getHumidity() {
      return this.humidity;
   }

   public String toString() {
      return "Main{temperature=" + this.temperature + "}";
   }
}
