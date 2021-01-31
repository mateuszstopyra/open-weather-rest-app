package com.ms.weather.repository;

import com.ms.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long> {

    Optional<Weather> getWeatherByCity(String city);

}
