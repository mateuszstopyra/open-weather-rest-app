package com.ms.weather.dto;

import lombok.Data;

@Data
public class OpenWeatherCurrentDto {

    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
    private OpenWeatherSysDto sys;
    private OpenWeatherDescDto[] weather;
    private String name;


}
