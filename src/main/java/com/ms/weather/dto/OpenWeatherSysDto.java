package com.ms.weather.dto;

import lombok.Data;

@Data
public class OpenWeatherSysDto {

    private String country;
    private Long sunrise;
    private Long sunset;

}
