package com.example.journalApp.services;

import com.example.journalApp.api.response.WeatherResponse;
import com.example.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    public static final String api_key="a5ff5ff9b452464c6a45da8c5a87482e";
//    String API_URL="https://api.weatherstack.com/current?access_key=API_KEY&query=city";

    @Autowired
    private AppCache appCache;
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String final_API=appCache.AppCache.get("weather_api").replace("<city>",city).replace("<apiKey>",api_key);
        ResponseEntity<WeatherResponse> response=restTemplate.exchange(final_API, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body=response.getBody();
        return body;
    }
}
