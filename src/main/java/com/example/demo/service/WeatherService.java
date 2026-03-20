package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public String getWeather() {

        String apiKey = "YOUR_API_KEY";

        String url =
        "https://api.openweathermap.org/data/2.5/weather?q=Vijayawada&appid="
        + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);
    }
}