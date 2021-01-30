package com.ms.weather.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "weather")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temperature;
    private int pressure;
    private int humidity;
    private double speed;
    private LocalDateTime lastUpdateDate;
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
