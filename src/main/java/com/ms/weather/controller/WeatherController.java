package com.ms.weather.controller;

import com.ms.weather.dto.WeatherDto;
import com.ms.weather.model.Weather;
import com.ms.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final ModelMapper modelMapper;
    private final WeatherService weatherService;

    @GetMapping(value = "/{city}")
    public WeatherDto getWeather(@PathVariable("city") String city){
        WeatherDto weatherDto = weatherService.getWeatherForCity(city);
        Weather weather = convertToEntity(weatherDto);
        weather.setCity(city);
        weatherService.update(weather);
        return convertToDto(weather);
    }

    public WeatherDto convertToDto(Weather weather){
        WeatherDto weatherDto = modelMapper.map(weather,WeatherDto.class);
        return weatherDto;
    }

    public Weather convertToEntity(WeatherDto weatherDto){
        Weather weather = modelMapper.map(weatherDto,Weather.class);
        return weather;
    }

}
