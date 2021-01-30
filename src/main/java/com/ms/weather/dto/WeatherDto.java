package com.ms.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class WeatherDto {

    @JsonIgnore
    private Long id;
    private double temperature;
    private int pressure;
    private int humidity;
    private double speed;
    private String city;
    private String description;
    private int feelsLike;
    private int tempMin;
    private int tempMax;
    private String country;
    private LocalTime sunrise;
    private LocalTime sunset;
    private String name;


}
