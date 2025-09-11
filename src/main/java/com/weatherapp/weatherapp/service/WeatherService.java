package com.weatherapp.weatherapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "weatherCache", key = "#cityId")
    public Map<String, Object> getWeather(String cityId) {
        
        System.out.println("Cache — storing data for: " + cityId);

        String url = "https://api.openweathermap.org/data/2.5/weather?id="
                + cityId + "&appid=" + apiKey + "&units=metric";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        Map<String, Object> result = new HashMap<>();
        result.put("name", response.get("name"));

        Map<String, Object> main = (Map<String, Object>) response.get("main");
        result.put("temp", main.get("temp"));

        List<Map<String, Object>> weatherList = (List<Map<String, Object>>) response.get("weather");
        if (!weatherList.isEmpty()) {
            result.put("description", weatherList.get(0).get("description"));
        }

        System.out.println(result); //test

        return result;
    }
}
