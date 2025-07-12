package com.example.journalApp.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WeatherResponse {


    public Current current;

    @Getter
    @Setter
    public class Current{

        public int temperature;
        public List<String> weather_descriptions;
        public int feelslike;

    }


}
