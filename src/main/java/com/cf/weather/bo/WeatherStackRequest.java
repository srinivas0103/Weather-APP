package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherStackRequest {
	public String type;
	public String query;
	public String language;
	public String unit;
}