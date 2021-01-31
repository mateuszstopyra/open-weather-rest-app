package com.ms.weather.service;

import com.ms.weather.dto.WeatherDto;
import com.ms.weather.model.Weather;
import com.ms.weather.repository.WeatherRepository;
import com.ms.weather.webclient.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherClient weatherClient;

    public Weather save(Weather weather){
        weather.setLastUpdateDate(LocalDateTime.now());
        return weatherRepository.save(weather);
    }

    @Transactional
    public Weather update(Weather weather){
        Optional<Weather> weatherOptional = weatherRepository.getWeatherByCity(weather.getCity());
        if(weatherOptional.isPresent()){
            Weather weatherToChange = weatherOptional.get();
            weatherToChange.setHumidity(weather.getHumidity());
            weatherToChange.setLastUpdateDate(LocalDateTime.now());
            weatherToChange.setPressure(weather.getPressure());
            weatherToChange.setSpeed(weather.getSpeed());
            weatherToChange.setTemperature(weather.getTemperature());
            weatherToChange.setCountry(weather.getCountry());
            weatherToChange.setSunrise(weather.getSunrise());
            weatherToChange.setSunset(weather.getSunset());
            weatherToChange.setName(weather.getName());
            weatherToChange.setFeelsLike(weather.getFeelsLike());
            weatherToChange.setTempMin(weather.getTempMin());
            weatherToChange.setTempMax(weather.getTempMax());
            weatherToChange.setDescription(weather.getDescription());
            return weatherToChange;
        }else{
            return save(weather);
        }
    }

    public WeatherDto getWeatherForCity(String city){
        return weatherClient.getWeatherForCity(city);
    }


}
