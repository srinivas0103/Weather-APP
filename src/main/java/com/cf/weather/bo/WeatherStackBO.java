package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherStackBO {
	public WeatherStackRequest request;
	public WeatherStackLocation location;
	public WeatherStackTemp current;
}






