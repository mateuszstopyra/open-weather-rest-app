package com.ms.weather.dto;

import lombok.Data;

@Data
public class OpenWeatherMainDto {

    private double temp;
    private int pressure;
    private int humidity;
    private int feels_like;
    private int temp_min;
    private int temp_max;

}
