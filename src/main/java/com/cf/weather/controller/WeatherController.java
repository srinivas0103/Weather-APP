package com.cf.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.weather.bo.RestWeatherResponseBO;
import com.cf.weather.services.WeatherService;


@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	WeatherService weatherService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<RestWeatherResponseBO> getWeatherForecast(@RequestParam(required = true) String city) {	
 		return (ResponseEntity<RestWeatherResponseBO>) weatherService.weatherForecastByCity(city);
    }

}
