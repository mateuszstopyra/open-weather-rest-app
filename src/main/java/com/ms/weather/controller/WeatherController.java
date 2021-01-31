package com.ms.weather.controller;

import com.ms.weather.dto.WeatherDto;
import com.ms.weather.model.Weather;
import com.ms.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final ModelMapper modelMapper;
    private final WeatherService weatherService;


    public WeatherDto convertToDto(Weather weather){
        WeatherDto weatherDto = modelMapper.map(weather,WeatherDto.class);
        return weatherDto;
    }

    public Weather convertToEntity(WeatherDto weatherDto){
        Weather weather = modelMapper.map(weatherDto,Weather.class);
        return weather;
    }

}
