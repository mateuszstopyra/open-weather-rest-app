package com.ms.weather.webclient;

import com.ms.weather.dto.OpenWeatherCurrentDto;
import com.ms.weather.dto.WeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalTime;
import java.util.TimeZone;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "86734ac33e6ef9f793f8b91c3ef21a9b";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city){
        OpenWeatherCurrentDto openWeatherCurrentDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherCurrentDto.class,
                city, API_KEY);

        return WeatherDto.builder()
                .speed(openWeatherCurrentDto.getWind().getSpeed())
                .humidity(openWeatherCurrentDto.getMain().getHumidity())
                .pressure(openWeatherCurrentDto.getMain().getPressure())
                .country(openWeatherCurrentDto.getSys().getCountry())
                .temperature(openWeatherCurrentDto.getMain().getTemp())
//                .description(openWeatherWeatherDto.getWeather().getDescription().get(0))
                .feelsLike(openWeatherCurrentDto.getMain().getFeels_like())
                .tempMin(openWeatherCurrentDto.getMain().getTemp_min())
                .tempMax(openWeatherCurrentDto.getMain().getTemp_max())
                .sunrise(timestampToLocalTime(openWeatherCurrentDto.getSys().getSunrise()))
                .sunset(timestampToLocalTime(openWeatherCurrentDto.getSys().getSunset()))
                .name(openWeatherCurrentDto.getName())
                .build();

    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects){
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }

    public static LocalTime timestampToLocalTime(Long timestamp){
        LocalTime localTime = LocalTime.ofInstant(Instant.ofEpochMilli(timestamp*1000), TimeZone.getDefault().toZoneId());
        return localTime;
    }



}
